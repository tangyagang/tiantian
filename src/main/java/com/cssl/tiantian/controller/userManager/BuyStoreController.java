package com.cssl.tiantian.controller.userManager;

import com.cssl.tiantian.pojo.Shop;
import com.cssl.tiantian.service.shop.ShopService;
import com.cssl.tiantian.tools.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/userManager")
public class BuyStoreController {

    @Resource
    private ShopService shopService;


    //后台user用户跳转页面,已购买过的店铺
    @RequestMapping("/buyStore")
    public String toBuyStore(@RequestParam(value = "shopName",required = false)String shopName, ModelMap modelMap){
        List<Shop> shopList = shopService.findAllByUserIdAndShopName(Constants.USER_SESSION.getUserId(),shopName);
        if (shopName != null && shopName != ""){
            modelMap.put("shopName", shopName);
        }
        modelMap.put("user", Constants.USER_SESSION);//用户信息
        modelMap.put("shopList", shopList);
        return "/userManager/buyStore";
    }
}
