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
    @RequestMapping("/findPwd")
    public String toFindPwd(){
        return "findPwd";
    }
    @RequestMapping("/finish")
    public String toFinish(){
        return "finish";
    }





}
