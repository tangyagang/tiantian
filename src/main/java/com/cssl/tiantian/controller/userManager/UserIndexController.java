package com.cssl.tiantian.controller.userManager;

import com.cssl.tiantian.pojo.Buycar;
import com.cssl.tiantian.pojo.Order;
import com.cssl.tiantian.pojo.Product;
import com.cssl.tiantian.pojo.ProductCollect;
import com.cssl.tiantian.pojo.vo.OrderStatusNumsVo;
import com.cssl.tiantian.pojo.vo.SearchOrderVo;
import com.cssl.tiantian.service.buyCar.BuyCarService;
import com.cssl.tiantian.service.order.OrderService;
import com.cssl.tiantian.service.productCollect.ProductCollectService;
import com.cssl.tiantian.tools.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/userManager")
public class UserIndexController {

    @Autowired
    private OrderService orderService;
    @Resource
    private BuyCarService buyCarService;
    @Resource
    private PublicUser publicUser;
    @Resource
    private ProductCollectService productCollectService;

    @RequestMapping("/userIndex")
    public String doUserIndex(ModelMap modelMap, HttpServletRequest request){
        //用户信息
        List<Order> list = orderService.findAll(Constants.USER_SESSION.getUserId());
        SearchOrderVo searchOrder = new SearchOrderVo();
        searchOrder.setUserId(Constants.USER_SESSION.getUserId());
        //买过的宝贝
        List<Order> orderList = orderService.findOrderBySearch(searchOrder);
        //购物车
        List<Buycar> buycarList = buyCarService.findAllByUserId(Constants.USER_SESSION.getUserId());
        //PublicUser publicUser = new PublicUser();
        //订单状态数量
        OrderStatusNumsVo orderStatusNums = publicUser.getOrderStatusNums(list);
        //浏览记录
        List<Product> productList = publicUser.queryHistory(request);
        //商品收藏
        List<ProductCollect> productCollectList = productCollectService.findAllProductCollectByUserId(Constants.USER_SESSION.getUserId(),null);
        modelMap.put("user", Constants.USER_SESSION);//用户信息
        modelMap.put("orderList", orderList);//买过的宝贝
        modelMap.put("buycarList", buycarList);//购物车
        modelMap.put("orderStatusNums",orderStatusNums);//订单状态数量
        modelMap.put("productList",productList);//浏览记录
        modelMap.put("productCollectList",productCollectList);//商品收藏
        return "/userManager/userIndex";
    }


}
