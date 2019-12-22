package com.cssl.tiantian.controller.superManager;

import com.cssl.tiantian.pojo.Order;
import com.cssl.tiantian.pojo.Page;
import com.cssl.tiantian.pojo.vo.SuperOrderListSearch;
import com.cssl.tiantian.service.order.OrderService;
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
public class OrderListController {

    @Resource
    private OrderService orderService;

    //跳转页面
    @RequestMapping("/superOrderList")
    public String supperOrderList(@RequestParam(value = "pageNo",required = false)String pageNo,
                                  SuperOrderListSearch search,
                                  ModelMap modelMap){
        Integer pn = pageNo != null && !pageNo.equals("") ? Integer.parseInt(pageNo) : 1;//当前页码
        PageInfo<Order> pageInfo = orderService.findAll(search,pn, Constants.PAGE_SIZE);
        int[] numbs = Page.getPageNumbers(pn, pageInfo.getPages());
        modelMap.put("user", Constants.USER_SESSION);//用户信息
        modelMap.put("pageInfo", pageInfo);
        modelMap.put("numbs", numbs);
        if (search != null && search.equals("")){
            modelMap.put("superOrderListSearch", search);
        }
        return "/superManager/superOrderList";
    }

    //关闭订单
    @RequestMapping("/closeOrder")
    @ResponseBody
    public boolean closeOrder(int orderId){
        Integer[] orderIds = {orderId};
        if (orderService.modifyStatusByUserId(orderIds, 5, Constants.USER_SESSION.getUserId()) > 0){
            return true;
        }
        return false;
    }










}
