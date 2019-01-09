package com.cssl.tiantian.controller;
/**
 * 首页查询
 */

import com.cssl.tiantian.pojo.News;
import com.cssl.tiantian.pojo.Page;
import com.cssl.tiantian.pojo.Product;
import com.cssl.tiantian.pojo.ProductCategory;
import com.cssl.tiantian.service.ProductCategory.ProductCategoryService;
import com.cssl.tiantian.service.news.NewsService;
import com.cssl.tiantian.service.product.ProductService;
import com.cssl.tiantian.tools.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/index",produces="text/plain;charset=UTF-8")
    public String listType(String pageNo,String proName , ModelMap modelMap){

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

        List<ProductCategory> list = productCategoryService.findAll(null);
        List<News> newsList = newsService.getAll();
        Page page = new Page<>();
        Integer pn = pageNo != null && pageNo.equals("") ? Integer.parseInt(pageNo) : 1;//当前页码
        int totalCount = productService.findCount(proName);//总数据量
        List<Product> products = productService.findProductByProName(proName,pn,Constants.PAGE_SIZE);//结果集
        int totalPage = totalCount % Constants.PAGE_SIZE == 0 ? totalCount / Constants.PAGE_SIZE : totalCount / Constants.PAGE_SIZE + 1;//总页数
        page.setList(products);
        page.setPageNo(pn);
        page.setPageSize(Constants.PAGE_SIZE);
        page.setTotalCount(totalCount);
        page.setTotalPage(totalPage);
        int[] numbs = Page.getPageNumbers(pn,totalPage);
        modelMap.put("productCategorys",list);
        modelMap.put("page",page);
        modelMap.put("newsList",newsList);
        modelMap.put("numbs",numbs);
        return "index";
    }
}
