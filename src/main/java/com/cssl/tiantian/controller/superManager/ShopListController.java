package com.cssl.tiantian.controller.superManager;

import com.cssl.tiantian.pojo.Page;
import com.cssl.tiantian.service.shop.ShopService;
import com.cssl.tiantian.tools.Constants;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/superManager")
public class ShopListController {

    @Resource
    private ShopService shopService;

    //查询所有
    @RequestMapping("/superShopList")
    public String toSuperShopList(@RequestParam(value = "pageNo",required = false)String pageNo,
                                  @RequestParam(value = "shopName",required = false)String shopName,
                                  @RequestParam(value = "userName",required = false)String userName,
                                  ModelMap modelMap){
        //用于传值到页面
        if (shopName != null && shopName != "") {
            modelMap.put("shopName", shopName);
            shopName = "%"+shopName+"%";
        }
        if (userName != null && userName != ""){
            modelMap.put("userName",userName);
            userName = "%"+userName+"%";
        }
        Integer pn = pageNo != null && !pageNo.equals("") ? Integer.parseInt(pageNo) : 1;//当前页码
        PageInfo pageInfo = shopService.findAllByShopNameAndUserName(pn, Constants.PAGE_SIZE,shopName,userName);
        int[] numbs = Page.getPageNumbers(pn,pageInfo.getPages());

        modelMap.put("user", Constants.USER_SESSION);//用户信息
        modelMap.put("pageInfo",pageInfo);
        modelMap.put("numbs",numbs);
        return "/superManager/superShopList";
    }

    //删除
    @RequestMapping("/delShop")
    @ResponseBody
    public boolean delShop(String shopId){
        if (shopId != null || shopId != ""){
            if (shopService.deleteShopByShopId(Integer.parseInt(shopId)) > 0)
                return true;
        }
        return false;
    }
}
