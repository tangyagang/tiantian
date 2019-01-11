package com.cssl.tiantian.controller;

import com.cssl.tiantian.pojo.Order;
import com.cssl.tiantian.service.order.OrderService;
import com.cssl.tiantian.tools.Constants;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class UserOrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/userOrder")
    public String userOrder(@RequestParam(value = "pageNo",required = false) String pageNo, ModelMap modelMap){
        Integer pn = pageNo != null && pageNo.equals("") ? Integer.parseInt(pageNo) : 1;//当前页码
        PageInfo<Order> pageInfo = orderService.findAllByUserId(2,pn, Constants.PAGE_SIZE);
        modelMap.put("pageInfo",pageInfo);
        return "/userManager/userOrder";
    }
}
