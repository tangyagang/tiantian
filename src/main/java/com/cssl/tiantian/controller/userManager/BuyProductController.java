package com.cssl.tiantian.controller.userManager;

import com.cssl.tiantian.pojo.Order;
import com.cssl.tiantian.pojo.OrderDetail;
import com.cssl.tiantian.pojo.Page;
import com.cssl.tiantian.service.order.OrderService;
import com.cssl.tiantian.service.orderDetail.OrderDetailService;
import com.cssl.tiantian.service.product.ProductService;
import com.cssl.tiantian.tools.Constants;
import com.github.pagehelper.PageInfo;
import org.apache.catalina.authenticator.SpnegoAuthenticator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping("/userManager")
public class BuyProductController {

    @Resource
    private OrderService orderService;
    @Resource
    private OrderDetailService orderDetailService;
    @Resource
    private ProductService productService;

    //跳转到已买宝贝
    @RequestMapping("/buyProduct")
    public String toBuyProduct(@RequestParam(value = "pageNo",required = false) String pageNo,
                               ModelMap modelMap){
        Integer pn = pageNo != null && !pageNo.equals("") ? Integer.parseInt(pageNo) : 1;//当前页码
        PageInfo<OrderDetail> pageInfo = orderDetailService.findAllByUserId(Constants.USER_SESSION.getUserId(), pn, Constants.PAGE_SIZE);
        int[] numbs = Page.getPageNumbers(pn, pageInfo.getPages());
        modelMap.put("user", Constants.USER_SESSION);//用户信息
        modelMap.put("pageInfo", pageInfo);
        modelMap.put("numbs", numbs);
        return "/userManager/buyProduct";
    }



}
