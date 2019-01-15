package com.cssl.tiantian.controller;

import com.cssl.tiantian.pojo.Buycar;
import com.cssl.tiantian.pojo.Page;
import com.cssl.tiantian.pojo.Product;
import com.cssl.tiantian.service.buyCar.BuyCarService;
import com.cssl.tiantian.tools.Constants;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/userManager")
public class ShoppingController {

    @Autowired
    private BuyCarService buyCarService;

    @RequestMapping("/doShopping")
    public String shopping(@RequestParam(value = "num") Integer num,
                           @RequestParam("proId") int proId,
                           HttpServletRequest request){
        int count = buyCarService.addByCar(Constants.USER_SESSION.getUserId(),proId,num);
        return "redirect:/userManager/toShopping";
    }

    @RequestMapping("/toShopping")
    public String toShopping(@RequestParam(value = "pageNo",required = false) String pageNo,ModelMap modelMap){
        Integer pn = pageNo != null && pageNo.equals("") ? Integer.parseInt(pageNo) : 1;//当前页码
        PageInfo<Buycar> pageInfo = buyCarService.findAllByUserId(Constants.USER_SESSION.getUserId(),pn,Constants.PAGE_SIZE);
        modelMap.put("pageInfo",pageInfo);
        modelMap.put("numbs", Page.getPageNumbers(pn,pageInfo.getPages()));
        return "/userManager/shopping";
    }
    //修改数量
    @RequestMapping(value = "/modifyNum",method = RequestMethod.GET)
    @ResponseBody
    public boolean modifyNum(int buyCarId,int num){
        //先判断库存是否足够
        Buycar buycar = buyCarService.findBuyCarById(buyCarId);
        if (buycar.getProduct().getStock() > num){
            return buyCarService.modifyBuyCar(buyCarId,num);
        }
       return false;
    }
    //批量删除购物车
/*    @RequestMapping(value = "/deleteBuycar",method = RequestMethod.GET)
    @ResponseBody
    public boolean deleteBuycar(int[] buyCarIds){
        System.out.println(buyCarIds.length);
        boolean isDelete = buyCarService.deleteBuyCarById(buyCarIds);
        return isDelete;
    }*/

}
