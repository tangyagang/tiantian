package com.cssl.tiantian.controller;

import com.cssl.tiantian.pojo.Page;
import com.cssl.tiantian.pojo.Product;
import com.cssl.tiantian.pojo.ProductCategory;
import com.cssl.tiantian.service.ProductCategory.ProductCategoryService;
import com.cssl.tiantian.service.product.ProductService;
import com.cssl.tiantian.tools.Constants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DailySelectionController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping("/doDailySelection")
    public String doDailySelection(@RequestParam(value = "pageNo",required = false) String pageNo, ModelMap modelMap){
        List<ProductCategory> list = productCategoryService.findAll(null);
        Page page = new Page<>();
        Integer pn = pageNo != null && pageNo.equals("") ? Integer.parseInt(pageNo) : 1;//当前页码
        int totalCount = productService.findCount(null);//总数据量
        List<Product> products = productService.findAllByOrder(pn, Constants.PAGE_SIZE);//结果集
        int totalPage = totalCount % Constants.PAGE_SIZE == 0 ? totalCount / Constants.PAGE_SIZE : totalCount / Constants.PAGE_SIZE + 1;//总页数
        page.setList(products);
        page.setPageNo(pn);
        page.setPageSize(Constants.PAGE_SIZE);
        page.setTotalCount(totalCount);
        page.setTotalPage(totalPage);
        int[] numbs = Page.getPageNumbers(pn,totalPage);
        modelMap.put("productCategorys",list);
        modelMap.put("page",page);
        modelMap.put("numbs",numbs);
        return "/dailySelection";

    }
}
