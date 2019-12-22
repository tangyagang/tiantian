package com.cssl.tiantian.controller.adminManager;

import com.cssl.tiantian.pojo.*;
import com.cssl.tiantian.pojo.vo.ProImgVo;
import com.cssl.tiantian.pojo.vo.ProductAddVo;
import com.cssl.tiantian.pojo.vo.ProductChangeVo;
import com.cssl.tiantian.pojo.vo.ProductModifyVo;
import com.cssl.tiantian.service.ProductCategory.ProductCategoryService;
import com.cssl.tiantian.service.proImg.ProImgService;
import com.cssl.tiantian.service.product.ProductService;
import com.cssl.tiantian.service.shop.ShopService;
import com.cssl.tiantian.tools.Constants;
import com.cssl.tiantian.tools.FileNameUtils;
import com.cssl.tiantian.tools.FileUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/adminManager")
public class AdminProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;
    @Resource
    private ProImgService proImgService;
    @Resource
    private ShopService shopService;

    @Value("${file.uploadProductFolder}")
    String uploadFolder;//资源文件绝对地址目录

    @Value("${file.staticProductPath}")
    String staticAccessPath;//静态资源对外暴露的访问路径


    //跳转到商品列表页面
    @RequestMapping("/productList")
    public String toProductList( @RequestParam(value = "pageNo",required = false) String pageNo,
                                 ModelMap modelMap){
        Integer pn = pageNo != null && !pageNo.equals("") ? Integer.parseInt(pageNo) : 1;//当前页码
        PageInfo<Product> pageInfo = productService.findAllByAdminId(Constants.USER_SESSION.getUserId(), pn, Constants.PAGE_SIZE);
        int[] numbs = Page.getPageNumbers(pn, pageInfo.getPages());
        modelMap.put("user", Constants.USER_SESSION);//用户信息
        modelMap.put("pageInfo", pageInfo);
        modelMap.put("numbs", numbs);
        return "/adminManager/productList";
    }

    //跳转到出售中商品页面
    @RequestMapping("/productStock")
    public String toProductStock(@RequestParam(value = "pageNo",required = false) String pageNo,
                                 ModelMap modelMap){
        Integer pn = pageNo != null && !pageNo.equals("") ? Integer.parseInt(pageNo) : 1;//当前页码
        PageInfo<Product> pageInfo = productService.findAllByAdminId(Constants.USER_SESSION.getUserId(), pn, Constants.PAGE_SIZE);
        int[] numbs = Page.getPageNumbers(pn, pageInfo.getPages());
        modelMap.put("user", Constants.USER_SESSION);//用户信息
        modelMap.put("pageInfo", pageInfo);
        modelMap.put("numbs", numbs);
        return "/adminManager/productStock";
    }

    //出售中商品下架
    @RequestMapping("/productLowerShelf")
    public String productLowerShelf(int[] proIds){
        if(proIds.length > 0){
            productService.modifyByProIds(proIds,1);
        }
        return "redirect:/adminManager/productStock";
    }

    //跳转到详情页
    @RequestMapping("/productDetail")
    public String productDetail(@RequestParam(value = "proId")int proId,
                                ModelMap modelMap){
        Product product = productService.findProductByProId(proId);
        List<ProductCategory> list = productCategoryService.findAll(0);
        modelMap.put("user", Constants.USER_SESSION);//用户信息
        modelMap.put("product",product);
        modelMap.put("cateList",list);
        return "/adminManager/productDetail";
    }

    //商品修改(快速修改)
    @RequestMapping("/productModify")
    public String toUpdateProduct(ProductModifyVo productModifyVo){
       /* if (zhekou != null && !"".equals(zhekou)){
            int isPrice = Double.valueOf(zhekou) == 1 ? 0 : 1;
            double newPrice = Double.valueOf(zhekou) == 1 ? productModifyVo.getProPrice() : productModifyVo.getProPrice() * Double.valueOf(zhekou);
            productModifyVo.setIsPrice(isPrice);
            productModifyVo.setNewPrice(newPrice);
        }*/
       if (productModifyVo.getProPrice() == productModifyVo.getNewPrice()){
           productModifyVo.setIsPrice(0);
       }else
           productModifyVo.setIsPrice(1);
        productService.modifyProductById(productModifyVo);
        return "redirect:/adminManager/productList";
    }

    //跳转到添加商品（发布）页面
    @RequestMapping("/productAdd")
    public String toProductAdd(ModelMap modelMap){
        List<ProductCategory> list = productCategoryService.findAll(0);
        List<Shop> shopList = shopService.findAllByUserId(Constants.USER_SESSION.getUserId());
        modelMap.put("user", Constants.USER_SESSION);//用户信息
        modelMap.put("cateList",list);
        modelMap.put("shopList", shopList);
        return "/adminManager/productAdd";
    }

    //发布商品
    @RequestMapping("/proAdd")
    public String proAdd(@ModelAttribute("productChangeVo") ProductAddVo productAddVo,
                         @RequestParam(value = "file",required = false) MultipartFile file,
                         @RequestParam(value = "files",required = false) MultipartFile[] files,
                         Map<String, Object> map,
                         HttpServletRequest request){
        int proId=0;
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
                if (name.equals("file")){
                    file = req.getFile(name); //根据name获取表单元素的文件对象
                    if (!file.isEmpty()){
                        String fileName = file.getOriginalFilename();//获取上传文件的原名
                        String suf = fileName.substring(fileName.lastIndexOf("."));//获取后缀
                        boolean isSuf = false;
                        if (suf.equalsIgnoreCase(".JPG")
                                || suf.equalsIgnoreCase(".GIF")
                                || suf.equalsIgnoreCase(".PNG")){
                            //JPG、GIF、PNG
                            isSuf = true;
                        }else {
                            //文件类型不匹配
                            request.setAttribute("message","文件类型不匹配，请上传正确的文件");
                        }
                        if ((int)file.getSize()<1024*1024*5){
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
                                    if (FileUtils.upload(file, path)){//调用transferTo实现上传
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
                                    return "forward:/adminManager/productList";
                                }
                                productAddVo.setProUrl(staticAccessPath.replace("*","") + "/" + newFileName);
                            }
                        }else {
                            //文件大小超过限制
                            request.setAttribute("message","文件大小超过限制");
                        }
                    }
                    if (productAddVo.getProPrice() == productAddVo.getNewPrice()){
                        productAddVo.setIsPrice(0);
                        productAddVo.setSpare((int)productAddVo.getProPrice() / 10);
                    }else {
                        productAddVo.setIsPrice(1);
                        productAddVo.setSpare((int)productAddVo.getNewPrice() / 10);
                    }
                    productAddVo.setIsDelete(0);
                    proId = productService.addProduct(productAddVo);
                    System.out.println("aaaa"+proId);
                }else if (name.equals("files")){
                    //向商品图片表插入数据
                    boolean flag = true;
                    for (int i=0;i<files.length;i++){
                        MultipartFile file1 = files[i];
                        if (!file1.isEmpty()){
                            String fileName = file1.getOriginalFilename();//原文件名
                            String suf = fileName.substring(fileName.lastIndexOf("."));//获取后缀
                            int filesize = 1024*1024*5;
                            if (file1.getSize()>filesize){
                                request.setAttribute(Constants.MESSAGE, "*上传大小不得超过5M");
                                flag = false;
                            }else if (suf.equalsIgnoreCase(".JPG")
                                    || suf.equalsIgnoreCase(".GIF")
                                    || suf.equalsIgnoreCase(".PNG")){
                                // 生成新的文件名
                                String newFileName = FileNameUtils.getFileName(fileName);
                                // 要上传的目标文件存放路径
                                String path = uploadFolder + "/" + newFileName;//上传的真实路径+新文件名
                                try {
                                    // 上传成功或者失败的提示
                                    String msg = "";
                                    if (FileUtils.upload(file1, path)){//调用transferTo实现上传
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
                                    return "forward:/adminManager/productList";
                                }
                                ProImgVo proImgVo = new ProImgVo();
                                proImgVo.setProId(proId);
                                proImgVo.setProImgUrl(staticAccessPath.replace("*","") + "/" + newFileName);
                                proImgVo.setShopId(productAddVo.getShopId());
                                proImgService.addProImg(proImgVo);
                            }
                        }
                    }
                }
            }
        }
        return "redirect:/adminManager/productList";
    }

    //点击商品列表中详情时跳转到商品修改页面的方法
    @RequestMapping("/ProductChange")
    public String ProChange(ModelMap modelMap,@RequestParam(value = "proId")int proId){
        Product product = productService.findProductByProId(proId);
        List<ProductCategory> list = productCategoryService.findAll(0);
        modelMap.put("user", Constants.USER_SESSION);//用户信息
        modelMap.put("product",product);
        modelMap.put("cateList",list);
        return "/adminManager/ProductChange";
    }

    //修改商品
    @RequestMapping("/proChange")
    public String proChange(@ModelAttribute("productChangeVo") ProductChangeVo productChangeVo,
                            @RequestParam(value = "file",required = false) MultipartFile file,
                            @RequestParam(value = "files",required = false) MultipartFile[] files,
                            Map<String, Object> map,
                            HttpServletRequest request){
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
                if (name.equals("file")){
                    file = req.getFile(name); //根据name获取表单元素的文件对象
                    if (!file.isEmpty()){
                        String fileName = file.getOriginalFilename();//获取上传文件的原名
                        String suf = fileName.substring(fileName.lastIndexOf("."));//获取后缀
                        boolean isSuf = false;
                        if (suf.equalsIgnoreCase(".JPG")
                                || suf.equalsIgnoreCase(".GIF")
                                || suf.equalsIgnoreCase(".PNG")){
                            //JPG、GIF、PNG
                            isSuf = true;
                        }else {
                            //文件类型不匹配
                            request.setAttribute("message","文件类型不匹配，请上传正确的文件");
                        }
                        if ((int)file.getSize()<1024*1024*5){
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
                                    if (FileUtils.upload(file, path)){//调用transferTo实现上传
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
                                productChangeVo.setProUrl(staticAccessPath.replace("*","") + "/" + newFileName);
                            }
                        }else {
                            //文件大小超过限制
                            request.setAttribute("message","文件大小超过限制");
                        }
                    }
                    if (productChangeVo.getProPrice() == productChangeVo.getNewPrice()){
                        productChangeVo.setIsPrice(0);
                    }else
                        productChangeVo.setIsPrice(1);
                    productService.modifyProductById(productChangeVo);
                }else if (name.equals("files")){
                    //向商品图片表插入数据
                    boolean flag = true;
                    for (int i=0;i<files.length;i++){
                        MultipartFile file1 = files[i];
                        if (!file1.isEmpty()){
                            String fileName = file1.getOriginalFilename();//原文件名
                            String suf = fileName.substring(fileName.lastIndexOf("."));//获取后缀
                            int filesize = 1024*1024*5;
                            if (file1.getSize()>filesize){
                                request.setAttribute(Constants.MESSAGE, "*上传大小不得超过5M");
                                flag = false;
                            }else if (suf.equalsIgnoreCase(".JPG")
                                        || suf.equalsIgnoreCase(".GIF")
                                        || suf.equalsIgnoreCase(".PNG")){
                                // 生成新的文件名
                                String newFileName = FileNameUtils.getFileName(fileName);
                                // 要上传的目标文件存放路径
                                String path = uploadFolder + "/" + newFileName;//上传的真实路径+新文件名
                                try {
                                    // 上传成功或者失败的提示
                                    String msg = "";
                                    if (FileUtils.upload(file1, path)){//调用transferTo实现上传
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
                                List<ProImg> proImgList = proImgService.findProImgByProId(productChangeVo.getProId());
                                Product product = productService.findProductByProId(productChangeVo.getProId());
                                ProImgVo proImgVo = new ProImgVo();
                                proImgVo.setProId(productChangeVo.getProId());
                                proImgVo.setProImgUrl(staticAccessPath.replace("*","") + "/" + newFileName);
                                proImgVo.setShopId(product.getShop().getShopId());
                                if (proImgList.size() < files.length){
                                    //没有就创建一个
                                    proImgService.addProImg(proImgVo);
                                }else {
                                    //修改
                                    ProImg proImg = proImgList.get(i);
                                    proImgVo.setProImgId(proImg.getProImgId());
                                    proImgService.modifyProImgById(proImgVo);
                                }
                            }
                        }
                    }
                }
            }
        }
        return "forward:/adminManager/productList";
    }

    //上架
    @RequestMapping("/upperShelf")
    @ResponseBody
    public boolean upperShelf(int[] proIds){
        if(proIds.length > 0){
            if(productService.modifyByProIds(proIds,0) > 0){
                return true;
            }
        }
        return false;
    }

    //下架
    @RequestMapping("/lowerShelf")
    @ResponseBody
    public boolean lowerShelf(int[] proIds){
        if(proIds.length > 0){
            if(productService.modifyByProIds(proIds,1) > 0){
                return true;
            }
        }
        return false;
    }

    //删除商品
    @RequestMapping("/delProductByProIds")
    @ResponseBody
    public boolean delProductByProIds(int[] proIds){
        if(proIds.length > 0){
            if(productService.delByProIds(proIds) > 0){
                return true;
            }
        }
        return false;
    }










}
