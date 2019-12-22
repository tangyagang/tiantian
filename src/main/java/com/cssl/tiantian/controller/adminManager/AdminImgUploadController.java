package com.cssl.tiantian.controller.adminManager;

import com.cssl.tiantian.pojo.User;
import com.cssl.tiantian.service.user.UserService;
import com.cssl.tiantian.tools.Constants;
import com.cssl.tiantian.tools.FileNameUtils;
import com.cssl.tiantian.tools.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
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
import java.util.Iterator;
import java.util.Map;

@Controller
@RequestMapping(value = "/adminManager")
public class AdminImgUploadController {

    @Autowired
    private UserService userService;

    /*ResourceLoader接口意味着任何实现的对象都能够返回Resource实例.
    所有的应用上下文实现了ResourceLoader接口，而且因此所有的应用上下文可以用于获取Resource实例。*/
    private final ResourceLoader resourceLoader;

    @Autowired
    public AdminImgUploadController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Value("${file.uploadFolder}")
    String uploadFolder;//资源文件绝对地址目录

    @Value("${file.staticAccessPath}")
    String staticAccessPath;//静态资源对外暴露的访问路径


    /**
     * 跳转到文件上传页面
     * @return
     */
    @RequestMapping("/userInfoImg")
    public String toUserImg(ModelMap modelMap){
        User user = userService.findUserByUserId(Constants.USER_SESSION.getUserId());
        modelMap.put("user", user);
        return "adminManager/userImg";
    }

    /**
     *
     * @param multipartFile 要上传的文件
     * @return
     */
    @RequestMapping("/userImgModify")
    public String upload(@ModelAttribute("user") User user,
                         @RequestParam("fileName") MultipartFile multipartFile,
                         Map<String, Object> map,
                         HttpServletRequest request, HttpServletResponse response){
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
                multipartFile = req.getFile(name); //根据name获取表单元素的文件对象
                String fileName = multipartFile.getOriginalFilename();//获取上传文件的原名
                String suf = fileName.substring(fileName.lastIndexOf("."));//获取后缀
                boolean isSuf = false;
                if (suf.equalsIgnoreCase(".JPG") || suf.equalsIgnoreCase(".GIF") || suf.equalsIgnoreCase(".PNG")){
                    //JPG、GIF、PNG
                    isSuf = true;
                }else {
                    //文件类型不匹配
                    request.setAttribute("message","文件类型不匹配，请上传正确的文件");
                }
                if ((int)multipartFile.getSize()<1024*1024*5){
                    if (isSuf){
                        // 生成新的文件名
                        String newFileName = FileNameUtils.getFileName(fileName);

                        //使用原文件名
                        //path = path + "/" + fileName;

                        //生成新的文件名,都是数字形式
                        //String newFileName = Constants.getNumber()+suf;

                        // 要上传的目标文件存放路径
                        String path = uploadFolder + "/" + newFileName;//上传的真实路径+新文件名
                        try {
                            // 上传成功或者失败的提示
                            String msg = "";
                            if (FileUtils.upload(multipartFile, path)){//调用transferTo实现上传
                                // 上传成功，给出页面提示
                                msg = "上传成功！";
                                map.put("picName",newFileName);
                            }else {
                                msg = "上传失败！";
                            }
                            // 显示图片
                            map.put("msg", msg);
                        } catch (Exception e) {
                            //文件类型不匹配
                            request.setAttribute("message","文件上传失败");
                        }
                        user.setUserUrl(staticAccessPath.replace("*","") + "/" + newFileName);
                        userService.modifyUser(user);
                    }
                }else {
                    //文件大小超过限制
                    request.setAttribute("message","文件大小超过限制");
                }
            }
        }
        return "forward:/adminManager/userInfoImg";
    }
/*  File upload = null;
        try {
            //在开发测试模式时，得到的地址为：{项目跟目录}/target/static/images/upload/
            //在打包成jar正式发布时，得到的地址为：{发布jar包目录}/static/images/upload/
            //获取跟目录
            //获取classes目录绝对路径
           // String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
            String path = ResourceUtils.getURL("classpath:").getPath();
            path = URLDecoder.decode(path, "utf-8");
            upload = new File(path);
        }  catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
       // File fileUpload = new File( upload.getAbsolutePath(),"static/img/upload/");
        File fileUpload = new File(Constants.UPLOAD);
        if(!fileUpload.exists()) {
            fileUpload.mkdirs();
        }
        System.out.println("path:"+fileUpload);*/

    //如果上传目录为/static/images/upload/，则可以如下获取：
       /* File upload = new File(path.getAbsolutePath(),"static/images/upload/");
        if(!upload.exists()) upload.mkdirs();
        System.out.println("upload url:"+upload.getAbsolutePath());
        System.out.println("upload url:"+upload);*/


}
