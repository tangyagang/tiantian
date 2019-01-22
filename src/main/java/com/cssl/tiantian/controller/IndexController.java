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
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<ProductCategory> list = productCategoryService.findAll(null);
        List<News> newsList = newsService.getAll();
        Page page = new Page<>();
        Integer pn = pageNo != null && !pageNo.equals("") ? Integer.parseInt(pageNo) : 1;//当前页码
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
        modelMap.put("proName",proName);
        return "index";
    }

    @RequestMapping(value = "/indexProduct")
    @ResponseBody
    public Map<String, Object> listType(String pageNo, String proName ){
        Map<String, Object> map = new HashMap<String, Object>();
        Page page = new Page<>();
        Integer pn = pageNo != null && !pageNo.equals("") ? Integer.parseInt(pageNo) : 1;//当前页码
        int totalCount = productService.findCount(proName);//总数据量
        List<Product> products = productService.findProductByProName(proName,pn,Constants.PAGE_SIZE);//结果集
        int totalPage = totalCount % Constants.PAGE_SIZE == 0 ? totalCount / Constants.PAGE_SIZE : totalCount / Constants.PAGE_SIZE + 1;//总页数
        page.setList(products);
        page.setPageNo(pn);
        page.setPageSize(Constants.PAGE_SIZE);
        page.setTotalCount(totalCount);
        page.setTotalPage(totalPage);
        int[] numbs = Page.getPageNumbers(pn,totalPage);
        map.put("page",page);
        map.put("numbs",numbs);
        return map;
    }
}
