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
    @RequestMapping("/userManager/addressModify")
    public String toAddressModify(){
        return "addressModify";
    }
    @RequestMapping("/userManager/buyStore")
    public String toBuyStore(){
        return "buyStore";
    }
    @RequestMapping("/userManager/myCollection")
    public String toMyCollection(){
        return "myCollection";
    }
    @RequestMapping("/userManager/myHistory")
    public String toMyHistory(){
        return "myHistory";
    }
    @RequestMapping("/userManager/proScore")
    public String toProScore(){
        return "proScore";
    }


    //后台admin卖家跳转页面
    @RequestMapping("/adminManager/orderList")
    public String toOrderList(){
        return "adminManager/orderList";
    }
    @RequestMapping("/adminManager/productAdd")
    public String toProductAdd(){
        return "adminManager/productAdd";
    }
    @RequestMapping("/adminManager/productDetail")
    public String toProductDetail(){
        return "adminManager/productDetail";
    }
    @RequestMapping("/adminManager/productList")
    public String toProductList(){
        return "adminManager/productList";
    }
    @RequestMapping("/adminManager/productStock")
    public String toProductStock(){
        return "adminManager/productStock";
    }
    @RequestMapping("/adminManager/updateProduct")
    public String toUpdateProduct(){
        return "adminManager/updateProduct";
    }

}
