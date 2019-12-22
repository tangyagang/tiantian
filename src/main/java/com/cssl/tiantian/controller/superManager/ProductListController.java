package com.cssl.tiantian.controller.superManager;

import com.cssl.tiantian.pojo.Page;
import com.cssl.tiantian.pojo.Product;
import com.cssl.tiantian.service.product.ProductService;
import com.cssl.tiantian.tools.Constants;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/superManager")
public class ProductListController {

    @Resource
    private ProductService productService;

    @RequestMapping("/superProduct")
    public String toSuperProduct(String pageNo, ModelMap modelMap){
        Integer pn = pageNo != null && !pageNo.equals("") ? Integer.parseInt(pageNo) : 1;//当前页码
        PageInfo<Product> pageInfo = productService.findAllByPage(pn, Constants.PAGE_SIZE);
        int[] numbs = Page.getPageNumbers(pn,pageInfo.getPages());
        modelMap.put("user", Constants.USER_SESSION);//用户信息
        modelMap.put("pageInfo",pageInfo);
        modelMap.put("numbs",numbs);
        return "/superManager/superProduct";
    }

    //下架
    @RequestMapping("/lowerShelf")
    @ResponseBody
    public boolean lowerShelf(int[] proIds){
        if(productService.modifyByProIds(proIds,1) > 0){
            return true;
        }
        return false;
    }

    //删除商品
    @RequestMapping("/delProductByProIds")
    @ResponseBody
    public boolean delProductByProIds(int[] proIds){
        if(productService.delByProIds(proIds) > 0){
            return true;
        }
        return false;
    }








}
