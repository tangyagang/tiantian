package com.cssl.tiantian.controller;

import com.cssl.tiantian.custom.MyException;
import com.cssl.tiantian.pojo.ProductCategory;
import com.cssl.tiantian.service.ProductCategory.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PublicProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    //@RequestMapping("/listType")
    /*public String listType(ModelMap modelMap){
        List<ProductCategory> list = productCategoryService.findAll(null);
        modelMap.put("productCategorys",list);
        return "listType";
    }*/

    //三级分类栏级联的ajax方法
    @RequestMapping( value = "/getProductCategory")
    @ResponseBody
    public  List<ProductCategory> list2(@RequestParam(value = "pcId") int pcId){
        List<ProductCategory> productCategoryList = productCategoryService.findAll(pcId);
        return productCategoryList;
    }

    @RequestMapping("/home")
    public String home() throws Exception {

//        throw new Exception("Sam 错误");
//        throw new MyException("101", "Sam 错误");
         throw new RuntimeException();
    }
}
