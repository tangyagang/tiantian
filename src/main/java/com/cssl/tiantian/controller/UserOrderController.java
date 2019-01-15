package com.cssl.tiantian.controller;

import com.cssl.tiantian.pojo.*;
import com.cssl.tiantian.service.buyCar.BuyCarService;
import com.cssl.tiantian.service.order.OrderService;
import com.cssl.tiantian.service.orderDetail.OrderDetailService;
import com.cssl.tiantian.service.product.ProductService;
import com.cssl.tiantian.service.user.UserService;
import com.cssl.tiantian.tools.Constants;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/userManager")
public class UserOrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private BuyCarService buyCarService;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @RequestMapping("/userOrder")
    public String userOrder(@RequestParam(value = "pageNo",required = false) String pageNo, ModelMap modelMap){
        Integer pn = pageNo != null && pageNo.equals("") ? Integer.parseInt(pageNo) : 1;//当前页码
        PageInfo<Order> pageInfo = orderService.findAllByUserId(Constants.USER_SESSION.getUserId(),pn, Constants.PAGE_SIZE);
        modelMap.put("pageInfo",pageInfo);
        return "/userManager/userOrder";
    }
    //查询用户余额是否足够支付订单
    @RequestMapping("/checkPrice")
    @ResponseBody
    public int checkPrice(@RequestParam("totalPrice") String totalPrice){
        if (Constants.USER_SESSION.getMoney() > Double.parseDouble(totalPrice))
            return 1;
        else
            return 0;
    }
    //添加订单
    @RequestMapping("/doSent")
    @ResponseBody
    public int doSent(@RequestParam(value = "buyCarIds") List<Integer> buyCarIds,@RequestParam("totalPrice") double totalPrice){
        int choose = 0; //未定义
        //1.根据购物车ID查询所有相关信息
        Integer[] ids = buyCarIds.toArray(new Integer[buyCarIds.size()]);
        List<Buycar> buycars = buyCarService.findAllBuycarById(ids);
        //2.向订单表插入数据，未成功插入：2
        Order order = new Order();
        order.setUser(Constants.USER_SESSION);
        order.setRecAddress(Constants.USER_SESSION.getRecAddresses().get(0));
        order.setCost(totalPrice);
        order.setOrderNum(Constants.getNumber());
        int orderId = orderService.addOrder(order);
        if (orderId > 0){
            //3.向订单详情表插入数据（商品价格转为冻结金额），为成功插入：3
            List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
            List<Product> products = new ArrayList<Product>(); //保存需要修改的商品
            for (Buycar buycar : buycars) {
                OrderDetail orderDetail = new OrderDetail();
                Product product = buycar.getProduct();//商品
                double cost = product.getIsPrice()==1 ? product.getNewPrice()*buycar.getNum() : product.getProPrice()*buycar.getNum();//小计金额
                double dPrice = product.getIsPrice()==1 ? (product.getProPrice()-product.getNewPrice())*buycar.getNum() : 0;//优惠金额
                orderDetail.setOrder(orderService.findOrderById(orderId));
                orderDetail.setProduct(product);
                orderDetail.setCost(cost);
                orderDetail.setCount(buycar.getNum());//数量
                orderDetail.setShop(product.getShop());//商店
                orderDetail.setFrozenPrice(cost);
                orderDetail.setdPrice(dPrice);
                orderDetails.add(orderDetail);
                //修改库存
                product.setStock(product.getStock()-buycar.getNum());
                products.add(product);
            }
            int count = orderDetailService.addOderDetailByMap(orderDetails);
            if (count > 0){
                //4.用户金钱减少,积分增加（10元=1积分），未成功：4;
                User user = Constants.USER_SESSION;
                user.setIntegra(user.getIntegra()+(int)Math.floor(totalPrice/10));
                user.setMoney(Constants.USER_SESSION.getMoney() - totalPrice);//测试用
                int isModify = userService.modifyUser(user);
                if (isModify > 0){
                    //5.修改库存，未成功：5；
                    boolean flag = true;
                    for (Product product : products) {
                        if (productService.modifyStockById(product.getProId(),product.getStock()) == 0){
                            flag = false;
                            choose = 5;
                            break;
                        }
                    }
                    if (flag){
                        //6.移出购物车相关商品，未成功：6；
                        if (buyCarService.deleteBuyCarById(ids)){
                            choose = 7;//已移除
                        }else
                            choose = 6;
                    }
                }else {
                    choose = 4;
                }
            }else{
                choose = 3;
            }
        }else {
            choose = 2;
        }
        return choose;
    }

    @RequestMapping("/toUserOrder")
    public String toUserOrder(){
        return "/userManager/userOrder";
    }


}
