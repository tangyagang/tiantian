package com.cssl.tiantian.controller.adminManager;

import com.cssl.tiantian.pojo.Order;
import com.cssl.tiantian.pojo.Page;
import com.cssl.tiantian.pojo.User;
import com.cssl.tiantian.pojo.vo.AdminSearchOrderVo;
import com.cssl.tiantian.pojo.vo.SearchOrderVo;
import com.cssl.tiantian.service.order.OrderService;
import com.cssl.tiantian.service.user.UserService;
import com.cssl.tiantian.tools.Constants;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/adminManager")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Resource
    private UserService userService;

    //跳转订单列表页面
    @RequestMapping("/orderList")
    public String toOrderList(AdminSearchOrderVo adminSearchOrderVo,
                              @RequestParam(value = "pageNo",required = false) String pageNo,
                              ModelMap modelMap){
        adminSearchOrderVo.setAdminId(Constants.USER_SESSION.getUserId());
        Integer pn = pageNo != null && !pageNo.equals("") ? Integer.parseInt(pageNo) : 1;//当前页码
        PageInfo pageInfo = orderService.findAllByAdminId(adminSearchOrderVo, pn,Constants.PAGE_SIZE );
        int[] numbs = Page.getPageNumbers(pn, pageInfo.getPages());
        modelMap.put("user", Constants.USER_SESSION);//用户信息
        modelMap.put("pageInfo", pageInfo);
        modelMap.put("numbs", numbs);
        modelMap.put("adminSearchOrderVo", adminSearchOrderVo);
        return "adminManager/orderList";
    }

    //跳转到订单详情页
    @RequestMapping("/orderDetails")
    public String orderDetails(@RequestParam("orderId")int orderId,
                               ModelMap modelMap){
        Order order = orderService.findOrderById(orderId);
        modelMap.put("user", Constants.USER_SESSION);//用户信息
        modelMap.put("Order", order);
        return "/adminManager/orderDetails";
    }

    //卖家发货
    @RequestMapping("/delivery")
    public String delivery(@RequestParam(value = "orderId")int orderId,
                            ModelMap modelMap){
        if (orderService.modifyStatusByOrderId(orderId, 2) > 0){
            return "redirect:/adminManager/orderList";
        }
        modelMap.put("message", "*发货失败，请检查输入是否有误！");
        return "forward:/adminManager/orderDetails?orderId="+orderId;
    }

    //关闭订单
    @RequestMapping("/closeOrder")
    public String closeOrder(@RequestParam(value = "orderId")int orderId,
                             ModelMap modelMap){
        //根据订单ID查询订单
        Order order = orderService.findOrderById(orderId);
        //1.修改订单状态
        if (orderService.modifyStatusByOrderId(orderId, 5) > 0){
            //2.将冻结金额返还给用户
            double frozenPrice = order.getOrderDetails().get(0).getFrozenPrice();
            User user = userService.findUserByUserId(order.getUser().getUserId());
            User us = new User();
            us.setUserId(user.getUserId());
            us.setMoney(user.getMoney()+frozenPrice);
            if (userService.modifyUser(us) > 0){
                return "redirect:/adminManager/orderList";
            }
        }
        modelMap.put("message", "*发货失败，请检查输入是否有误！");
        return "forward:/adminManager/orderDetails?orderId="+orderId;
    }












}
