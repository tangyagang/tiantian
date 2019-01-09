package com.cssl.tiantian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SkipController {

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
    @RequestMapping("/addressModify")
    public String toAddressModify(){
        return "userManager/addressModify";
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
}
