package com.cssl.tiantian.controller;
/**
 * 首页查询
 */

import com.cssl.tiantian.pojo.Product;
import com.cssl.tiantian.pojo.ProductCategory;
import com.cssl.tiantian.service.ProductCategory.ProductCategoryService;
import com.cssl.tiantian.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private ProductService productService;

    @RequestMapping("/index")
    public String listType(ModelMap modelMap){
        List<ProductCategory> list = productCategoryService.findAll();
        List<Product> products = productService.findAll();
        modelMap.put("productCategorys",list);
        modelMap.put("products",products);
        return "index";
    }
}
