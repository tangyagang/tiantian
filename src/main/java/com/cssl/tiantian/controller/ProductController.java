package com.cssl.tiantian.controller;

import com.cssl.tiantian.pojo.Page;
import com.cssl.tiantian.pojo.ProScore;
import com.cssl.tiantian.pojo.Product;
import com.cssl.tiantian.pojo.ProductCategory;
import com.cssl.tiantian.service.ProductCategory.ProductCategoryService;
import com.cssl.tiantian.service.proScore.ProScoreService;
import com.cssl.tiantian.service.product.ProductService;
import com.cssl.tiantian.tools.Constants;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private ProScoreService proScoreService;

    //分类查询所有商品(一、二级分类)
    @RequestMapping("/doDetail")
    public String doDetail(@RequestParam(value = "pcId",required = false) int pcId,String pageNo, ModelMap modelMap){
        List<ProductCategory> list = productCategoryService.findAll(null);
        ProductCategory productCategory = productCategoryService.findProductCategoryByPcId(pcId);
        Page page = new Page<>();
        Integer pn = pageNo != null && pageNo.equals("") ? Integer.parseInt(pageNo) : 1;//当前页码
        int totalCount = productService.findCountByPcId(pcId);//总数据量
        List<Product> products = productService.findProductByPcId(pcId,pn, Constants.PAGE_SIZE);//结果集
        int totalPage = totalCount % Constants.PAGE_SIZE == 0 ? totalCount / Constants.PAGE_SIZE : totalCount / Constants.PAGE_SIZE + 1;//总页数
        page.setList(products);
        page.setPageNo(pn);
        page.setPageSize(Constants.PAGE_SIZE);
        page.setTotalCount(totalCount);
        page.setTotalPage(totalPage);
        int[] numbs = Page.getPageNumbers(pn,totalPage);
        modelMap.put("productCategorys",list);
        modelMap.put("productCategory",productCategory);
        modelMap.put("page",page);
        modelMap.put("numbs",numbs);
        return "/detail";
    }

    //分类查询所有商品(三级分类)
    @RequestMapping("/doDetail2")
    public String doDetail2(@RequestParam(value = "pcId",required = false) int pcId,String pageNo, ModelMap modelMap){
        List<ProductCategory> list = productCategoryService.findProductCategoryByPcId3(pcId);//所有同级分类
        ProductCategory productCategory = productCategoryService.findProductCategoryByPcId(pcId);//查询所属分类
        Page page = new Page<>();
        Integer pn = pageNo != null && pageNo.equals("") ? Integer.parseInt(pageNo) : 1;//当前页码
        int totalCount = productService.findCountByPcId3(pcId);//总数据量
        List<Product> products = productService.findProductByPcId3(pcId,pn, Constants.PAGE_SIZE);//结果集
        int totalPage = totalCount % Constants.PAGE_SIZE == 0 ? totalCount / Constants.PAGE_SIZE : totalCount / Constants.PAGE_SIZE + 1;//总页数
        page.setList(products);
        page.setPageNo(pn);
        page.setPageSize(Constants.PAGE_SIZE);
        page.setTotalCount(totalCount);
        page.setTotalPage(totalPage);
        int[] numbs = Page.getPageNumbers(pn,totalPage);
        modelMap.put("productCategorys",list);
        modelMap.put("productCategory",productCategory);
        modelMap.put("page",page);
        modelMap.put("numbs",numbs);
        return "/detail2";
    }

    @RequestMapping("/productDetails")
    public String productDetails( int proId,String pageNo,ModelMap modelMap){
        Product product = productService.findProductByProId(proId);
        Integer pn = pageNo != null && pageNo.equals("") ? Integer.parseInt(pageNo) : 1;//当前页码
        PageInfo<ProScore> pageInfo = proScoreService.findAllByProId(proId,pn,Constants.PAGE_SIZE);
        int[] numbs = Page.getPageNumbers(pn,pageInfo.getPages());
        modelMap.put("product",product);
        modelMap.put("pageInfo",pageInfo);
        modelMap.put("numbs",numbs);
        return "productDetails";
    }
   /* @RequestMapping("/pro")
    public void findProductByProId(){
        Product product = productService.findProductByProId(1);
        int count = productService.getCount("手1");
        List<Product> products = productService.getProductByProName("手");
        System.out.println(">,..>>"+count);
        System.out.println(product.getProName()+">>>"+product.getShop().getShopName()+">>>"+product.getShop().getUser().getUserName());
    }*/


}
