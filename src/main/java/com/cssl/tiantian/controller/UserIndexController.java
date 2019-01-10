package com.cssl.tiantian.controller;

import com.cssl.tiantian.tools.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

@Controller
public class UserIndexController {

    public String doUserIndex(ModelMap modelMap){
        modelMap.put("user", Constants.USER_SESSION);
        return "/userManager/userIndex";
    }
}
