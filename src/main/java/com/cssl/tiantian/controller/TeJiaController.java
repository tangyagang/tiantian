package com.cssl.tiantian.controller;

import com.cssl.tiantian.pojo.Page;
import com.cssl.tiantian.pojo.Product;
import com.cssl.tiantian.pojo.ProductCategory;
import com.cssl.tiantian.service.ProductCategory.ProductCategoryService;
import com.cssl.tiantian.service.product.ProductService;
import com.cssl.tiantian.tools.Constants;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TeJiaController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping("/tejia")
    public String doTeJia(@RequestParam(value = "pageNo",required = false) String pageNo,
                          @RequestParam(value = "proName",required = false)String proName,
                          ModelMap modelMap){
        List<ProductCategory> list = productCategoryService.findAll(null);
        Integer pn = pageNo != null && !pageNo.equals("") ? Integer.parseInt(pageNo) : 1;//当前页码
        PageInfo<Product> pageInfo = productService.findAllByPrice(proName,pn,Constants.PAGE_SIZE);
        int[] numbs = Page.getPageNumbers(pn,pageInfo.getPages());//页号
        modelMap.put("productCategorys",list);
        modelMap.put("pageInfo",pageInfo);
        modelMap.put("numbs",numbs);
        modelMap.put("proName", proName);
        return "/tejia";

    }
}
