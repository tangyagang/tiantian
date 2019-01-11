package com.cssl.tiantian.controller;

import com.cssl.tiantian.pojo.Order;
import com.cssl.tiantian.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserOrder {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/userOrder")
    public String userOrder(ModelMap modelMap){
        List<Order> list = orderService.findAllByUserId(2);
        return "/userManager/userOrder";
    }
}
