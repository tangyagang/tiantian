package com.cssl.tiantian.controller;

import com.cssl.tiantian.pojo.*;
import com.cssl.tiantian.service.sellOrder.SellOrderService;

import com.cssl.tiantian.tools.Constants;
import com.cssl.tiantian.vo.SellFindVo;
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
public class OrderController {

    @Autowired
    SellOrderService orderService;







    //跳转到卖家订单列表
    @RequestMapping("/sellManager/SellOrder")
    public String OrderList(@RequestParam(value = "pageNo",required = false) String pageNo, ModelMap modelmap,
                            HttpServletRequest request){
        User user=(User)request.getSession().getAttribute("User");
        Page page = new Page<>();
        Integer pn = pageNo != null || pageNo.equals("") ? Integer.parseInt(pageNo) : 1;//当前页码
        int totalCount =orderService.findCountByUserId(user.getUserId());//总数据量
        List<Order> orderList = orderService.getOrderByUserId(user.getUserId(),(pn*Constants.PAGE_SIZE)-4,pn*Constants.PAGE_SIZE);//结果集
        int totalPage = totalCount % Constants.PAGE_SIZE == 0 ? totalCount / Constants.PAGE_SIZE : totalCount / Constants.PAGE_SIZE + 1;//总页数
        page.setList(orderList);
        page.setPageNo(pn);
        page.setPageSize(Constants.PAGE_SIZE);
        page.setTotalCount(totalCount);
        page.setTotalPage(totalPage);
        int[] numbs = Page.getPageNumbers(pn,totalPage);
        request.getSession().setAttribute("User",user);
        modelmap.put("OrderList",orderList);
        modelmap.put("page",page);
        modelmap.put("numbs",numbs);
        return "/sellManager/OrderList";
    }

    //发货
    @RequestMapping("/sellManager/delivery")
        public  String delivery(ModelMap modelmap,@RequestParam(value = "orderId") int orderId,HttpServletRequest request){
        orderService.updateOrderByStatus(orderId,3);
        User user=(User)request.getSession().getAttribute("User");
        List<Order> orderList=orderService.getAll1(user.getUserId());
        modelmap.put("OrderList",orderList);
        return "/sellManager/OrderList";
    }
    //点击商品名称或者点击发货按键时，跳转到订单详情页面
    @RequestMapping("/sellManager/OrderDetails")
    public String OrderDetails(ModelMap modelmap,HttpServletRequest request){
        User a=(User)request.getSession().getAttribute("User");
        modelmap.put("Order",orderService.getOrderByOrderId(Integer.parseInt(request.getQueryString()),a.getUserId()));
        return "/sellManager/OrderDetails";
    }


    //表头导航，根据session中的User.userId和URL中传过来的参数查询特定status状态商品
    @RequestMapping("/sellManager/OrderWait")
    public String Wait(ModelMap modelMap,@RequestParam(value = "pageNo",required = false) String pageNo,@ModelAttribute("user")User user,HttpServletRequest request){
        User a=(User)request.getSession().getAttribute("User");
        modelMap.put("OrderList",orderService.getStatusByUserID(a.getUserId(), Integer.parseInt(request.getQueryString())));
        return "/sellManager/OrderList";
    }

    //模糊查询方法，将查询FROM表单注入SellFindVo类中
    @RequestMapping("/sellFindOrder")
        public String Find(@ModelAttribute("from") SellFindVo vo, ModelMap modelMap, HttpServletRequest request){
        User user=(User) request.getSession().getAttribute("User");
        vo.setShopId(user.getUserId());
        modelMap.put("OrderList",orderService.getOrderByOption(vo));
        return "/sellManager/OrderList";
    }

    //关闭订单，并将冻结资金解锁转入买家账户
    @RequestMapping("/sellManager/CloseOrder")
        public String CloseOrder(HttpServletRequest request) {
        User a=(User)request.getSession().getAttribute("User");
        Order ord=orderService.getOrderByOrderId(Integer.parseInt(request.getQueryString()),a.getUserId());
        double money=ord.getCost();
        System.out.println(money);
        if(ord.getStatus()==1){
        orderService.closeOrder(Integer.parseInt(request.getQueryString()));}
        if(ord.getStatus()==2){
            orderService.closeOrder(Integer.parseInt(request.getQueryString()));
            orderService.updateOrderDetail(ord.getOrderId());
            orderService.addUserMoney(a.getUserId(),money);
        }
        return "forward:/sellManager/SellOrder";
    }


}
