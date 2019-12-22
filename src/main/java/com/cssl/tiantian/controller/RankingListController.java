package com.cssl.tiantian.controller;

import com.cssl.tiantian.pojo.Page;
import com.cssl.tiantian.pojo.Product;
import com.cssl.tiantian.pojo.ProductCategory;
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
public class RankingListController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/rankingList")
    public String doRankingList(@RequestParam(value = "pageNo",required = false) String pageNo,
                                @RequestParam(value = "proName",required = false)String proName,
                                ModelMap modelMap){
        Integer pn = pageNo != null && !pageNo.equals("") ? Integer.parseInt(pageNo) : 1;//当前页码
        PageInfo<Product> pageInfo = productService.findAllByOrderCount(proName,pn, Constants.PAGE_SIZE);
        int[] numbs = Page.getPageNumbers(pn,pageInfo.getPages());//页号
        modelMap.put("pageInfo",pageInfo);
        modelMap.put("numbs",numbs);
        modelMap.put("proName", proName);
        return "rankingList";
    }
}
