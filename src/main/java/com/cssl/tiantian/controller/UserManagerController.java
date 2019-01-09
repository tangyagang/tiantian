package com.cssl.tiantian.controller;
/**
 * 买家后台管理
 */

import com.cssl.tiantian.pojo.Areas;
import com.cssl.tiantian.pojo.Provinces;
import com.cssl.tiantian.pojo.User;
import com.cssl.tiantian.service.areas.AreasService;
import com.cssl.tiantian.service.product.ProductService;
import com.cssl.tiantian.service.provinces.ProvincesService;
import com.cssl.tiantian.service.user.UserService;
import com.cssl.tiantian.tools.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Controller
//@RequestMapping(value = "/userManager")
public class UserManagerController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProvincesService provincesService;
    @Autowired
    private AreasService areasService;

    @RequestMapping("/userInfo")
    public String user(ModelMap modelMap){
        User user = userService.findUserByUserId(1);
        List<Provinces> addressList = provincesService.findAll();
        //Provinces provinces = provincesService.findProvincesByAreaId(1801);
        Areas areas = areasService.findAreasByAreaId(1801);
        modelMap.put("user",user);
        modelMap.put("addressList",addressList);
        //modelMap.put("provinces",provinces);
        modelMap.put("areas",areas);
        return "/userManager/userInfo";
    }
    @RequestMapping("/userModify")
    public String userIndex(@ModelAttribute("user")User user,
                            @RequestParam("areaId") String areaId,
            /*  @ModelAttribute("multiFileUploadForm") CommonsMultipartFile multipartFile,*/
                             HttpServletRequest request, HttpServletResponse response) throws IOException {
      /*  File path1 = new File(ResourceUtils.getURL("classpath:").getPath());
        File upload = new File(path1.getAbsolutePath(), "static/upload/");
        if (!upload.exists())
            upload.mkdirs();
        String path = upload + "\\";*/
        String path = Constants.UPLOAD;
        path = URLDecoder.decode(path, "utf-8");
        //创建CommonsMultipartResolver
        CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getServletContext());
        resolver.setDefaultEncoding("UTF-8");//编码
        resolver.setResolveLazily(true);//resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
        resolver.setMaxUploadSize(1024);//上传文件的总大小限制
        resolver.setMaxInMemorySize(3024);//缓存大小限制
        resolver.setMaxUploadSizePerFile(1024);//单个文件大小限制
        //判断是否为文件上传表单
        if(resolver.isMultipart(request)){
            //如果是一个文件上传表单，就把HttpRequest转为spring的MultipartHttpRequest
            MultipartHttpServletRequest req = (MultipartHttpServletRequest)request;
            //获取表单中所有文件名字的迭代器【不是文件名，是文件表单的name】
            Iterator<String> fileNames = req.getFileNames();
            //循环迭代这些文件的名字
            while(fileNames.hasNext()){
                String name = fileNames.next(); //得到一个name
                MultipartFile file = req.getFile(name); //根据name获取表单元素的文件对象
                String fileName = file.getOriginalFilename();//获取上传文件的原名
                String suf = fileName.substring(fileName.lastIndexOf("."));//获取后缀
                boolean isSuf = false;
                if (suf.equalsIgnoreCase(".JPG") || suf.equalsIgnoreCase(".GIF") || suf.equalsIgnoreCase(".PNG")){
                    //JPG、GIF、PNG
                    isSuf = true;
                }else {
                    //文件类型不匹配
                    request.setAttribute("message","文件类型不匹配，请上传正确的文件");
                }
                if ((int)file.getSize()<1024*1024*5){
                    if (isSuf){
                        //生成新的文件名
                        long time = System.currentTimeMillis();
                        int rand = new Random().nextInt(1000);
                        String newFileName = String.valueOf(time)+rand+suf;
                        //拼接路径
                        path += newFileName;
                        File file1 = new File(path);
                        try {
                            file.transferTo(file1); //调用transferTo实现上传
                        } catch (Exception e) {
                            //文件类型不匹配
                            request.setAttribute("message","文件上传失败");
                        }
                        user.setUserUrl(path);
                        userService.modifyUser(user);
                    }
                }else {
                    //文件大小超过限制
                    request.setAttribute("message","文件大小超过限制");
                }
            }
        }
        return "userManager/userIndex";
    }
}
