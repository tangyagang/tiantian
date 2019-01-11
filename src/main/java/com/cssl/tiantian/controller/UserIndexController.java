package com.cssl.tiantian.controller;

import com.cssl.tiantian.tools.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserIndexController {


    @RequestMapping("/userIndex")
    public String doUserIndex(ModelMap modelMap){
        modelMap.put("user", Constants.USER_SESSION);
        return "/userManager/userIndex";
    }
}
