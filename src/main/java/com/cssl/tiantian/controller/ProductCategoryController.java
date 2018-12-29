package com.cssl.tiantian.controller;

import com.cssl.tiantian.pojo.ProductCategory;
import com.cssl.tiantian.service.ProductCategory.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//@Controller
public class ProductCategoryController {

    //@Autowired
    private ProductCategoryService productCategoryService;

    //@RequestMapping("/listType")
    public String listType(ModelMap modelMap){
        List<ProductCategory> list = productCategoryService.findAll();
        modelMap.put("productCategorys",list);
        return "listType";
    }
}
