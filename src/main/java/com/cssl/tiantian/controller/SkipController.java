package com.cssl.tiantian.controller;
/**
 * 直接跳转
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SkipController {

    //前台跳转页面
    @RequestMapping("/login")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/register")
    public String toRegister(){
        return "register";
    }
    @RequestMapping("/detail")
    public String toDetail(){
        return "detail";
    }
    @RequestMapping("/detail2")
    public String toDetail2(){
        return "detail2";
    }
    @RequestMapping("/dailySelection")
    public String toDailySelection(){
        return "dailySelection";
    }
    @RequestMapping("tejia")
    public String toTeJia(){
        return "tejia";
    }
    @RequestMapping("/rankingList")
    public String toRankingList(){
        return "rankingList";
    }
    @RequestMapping("/findPwd")
    public String toFindPwd(){
        return "findPwd";
    }
    @RequestMapping("/finish")
    public String toFinish(){
        return "finish";
    }

    //后台user用户跳转页面
    @RequestMapping("/addressModify")
    public String toAddressModify(){
        return "addressModify";
    }
    @RequestMapping("/buyStore")
    public String toBuyStore(){
        return "buyStore";
    }
    @RequestMapping("/myCollection")
    public String toMyCollection(){
        return "myCollection";
    }
    @RequestMapping("/myHistory")
    public String toMyHistory(){
        return "myHistory";
    }
    @RequestMapping("/proScore")
    public String toProScore(){
        return "proScore";
    }

    //后台admin卖家跳转页面
    @RequestMapping("/orderList")
    public String toOrderList(){
        return "adminManager/orderList";
    }
    @RequestMapping("/productAdd")
    public String toProductAdd(){
        return "adminManager/productAdd";
    }
    @RequestMapping("/productDetail")
    public String toProductDetail(){
        return "adminManager/productDetail";
    }
    @RequestMapping("/productList")
    public String toProductList(){
        return "adminManager/productList";
    }
    @RequestMapping("/productStock")
    public String toProductStock(){
        return "adminManager/productStock";
    }
    @RequestMapping("/updateProduct")
    public String toUpdateProduct(){
        return "adminManager/updateProduct";
    }

}
