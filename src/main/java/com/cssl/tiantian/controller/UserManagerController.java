package com.cssl.tiantian.controller;
/**
 * 买家后台管理
 */

import com.cssl.tiantian.pojo.Areas;
import com.cssl.tiantian.pojo.Provinces;

import com.cssl.tiantian.pojo.User;
import com.cssl.tiantian.service.areas.AreasService;
import com.cssl.tiantian.service.product.ProductService;
import com.cssl.tiantian.service.provinces.ProvincesService;
import com.cssl.tiantian.service.user.UserService;
import com.cssl.tiantian.tools.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/userManager")
public class UserManagerController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProvincesService provincesService;
    @Autowired
    private AreasService areasService;

    @RequestMapping("/userInfo")
    public String user(ModelMap modelMap){
        User user = userService.findUserByUserId(Constants.USER_SESSION.getUserId());
        List<Provinces> addressList = provincesService.findAll();
        Areas areas = areasService.findAreasByAreaId(user.getAreas().getAreaId());
        modelMap.put("user",user);
        modelMap.put("addressList",addressList);
        modelMap.put("areas",areas);
        return "/userManager/userInfo";
    }
    @RequestMapping("/userModify")
    public String userModify(@ModelAttribute("user") User user,
                             @RequestParam("areaId") String areaId,
                             ModelMap modelMap,
                             HttpServletRequest request, HttpServletResponse response){
        Areas areas = new Areas();
        areas.setAreaId(Integer.valueOf(areaId.trim().replace(",","")));
        user.setAreas(areas);
        int count = userService.modifyUser(user);
        if (count==0){
            modelMap.put("message","修改失败");        }
        return "redirect:/userManager/userInfo";
    }


}
