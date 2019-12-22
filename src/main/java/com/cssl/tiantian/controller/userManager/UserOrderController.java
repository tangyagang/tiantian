package com.cssl.tiantian.controller.userManager;

import com.cssl.tiantian.pojo.*;
import com.cssl.tiantian.pojo.vo.SearchOrderVo;
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

    //跳转至订单页面;//根据搜索条件查询相关订单
    @RequestMapping("/userOrder")
    public String userOrder(SearchOrderVo searchOrder,
                            @RequestParam(value = "pageNo",required = false) String pageNo,
                            ModelMap modelMap){
        Integer pn = pageNo != null && !pageNo.equals("") ? Integer.parseInt(pageNo) : 1;//当前页码
        searchOrder.setUserId(Constants.USER_SESSION.getUserId());
        PageInfo<Order> pageInfo = orderService.findOrderBySearch(searchOrder,pn, Constants.PAGE_SIZE);
        int num1 = 0;//待发货
        int num2 = 0;//待收货
        int num3 = 0;//待评价
        List<Order> list = orderService.findAll(Constants.USER_SESSION.getUserId());
        for (int i=0;i<list.size();i++){
            Order order = list.get(i);
            if (order.getStatus()==1){
                num1++;
            }else if (order.getStatus()==2){
                num2++;
            }else {
                num3++;
            }
        }
        int[] numbs = Page.getPageNumbers(pn, pageInfo.getPages());
        modelMap.put("user", Constants.USER_SESSION);//用户信息
        modelMap.put("pageInfo",pageInfo);
        modelMap.put("numbs",numbs);
        modelMap.put("num1",num1);
        modelMap.put("num2",num2);
        modelMap.put("num3",num3);
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
    public int doSent(@RequestParam(value = "buyCarIds") List<Integer> buyCarIds){
        int choose = 0; //未定义
        //1.根据购物车ID查询所有相关信息
        Integer[] ids = buyCarIds.toArray(new Integer[buyCarIds.size()]);
        List<Buycar> buycars = buyCarService.findAllBuycarById(ids);
        for (Buycar buycar : buycars) {
            Product product = buycar.getProduct();//商品
            double cost = product.getIsPrice()==1 ? product.getNewPrice()*buycar.getNum() : product.getProPrice()*buycar.getNum();//小计金额
            double dPrice = product.getIsPrice()==1 ? (product.getProPrice()-product.getNewPrice())*buycar.getNum() : 0;//优惠金额//生成订单
            Order order = new Order();
            order.setUser(Constants.USER_SESSION);
            List<RecAddress> recAddressList = Constants.USER_SESSION.getRecAddresses();
            int index=0;
            for (int i=0;i<recAddressList.size();i++){
                if (recAddressList.get(i).getIsDefault()==1){
                    index=i;
                    break;
                }
            }
            order.setRecAddress(Constants.USER_SESSION.getRecAddresses().get(index));
            order.setCost(cost);
            order.setOrderNum(Constants.getNumber());//订单编号
            int orderId = orderService.addOrder(order);
            if (orderId > 0){
                //3.向订单详情表插入数据（商品价格转为冻结金额），未成功插入：3
                List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
                List<Product> products = new ArrayList<Product>(); //保存需要修改的商品
                //2.向订单详情表插入数据，未成功插入：2
                OrderDetail orderDetail = new OrderDetail();
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
                int count = orderDetailService.addOderDetailByMap(orderDetails);
                if (count > 0){
                    //4.用户金钱减少,积分增加（10元=1积分），未成功：4;
                    User user = Constants.USER_SESSION;
                    user.setIntegra(user.getIntegra()+(int)Math.floor(cost/10));
                    user.setMoney(Constants.USER_SESSION.getMoney() - cost);
                    int isModify = userService.modifyUser(user);
                    if (isModify > 0){
                        //5.修改库存，未成功：5；
                        boolean flag = true;
                        for (Product pro : products) {
                            if (productService.modifyStockById(pro.getProId(),pro.getStock()) == 0){
                                flag = false;
                                choose = 5;
                                break;
                            }
                        }
                        if (flag){
                            //6.移出购物车相关商品，未成功：6；
                            if (buyCarService.deleteBuyCarById(buycar.getBuyCarId())){
                                choose = 7;//已移除
                            }else
                                choose = 6;
                        }else {
                            choose = 5;
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
        }
        return choose;
    }

    /*//添加订单
    @RequestMapping("/doSent")
    @ResponseBody
    public int doSent(@RequestParam(value = "buyCarIds") List<Integer> buyCarIds){
        int choose = 0; //未定义
        //1.根据购物车ID查询所有相关信息
        Integer[] ids = buyCarIds.toArray(new Integer[buyCarIds.size()]);
        //List<Buycar> buycars = buyCarService.findAllBuycarById(ids);
        //根据商店ID拆分订单
        int[] shopIds = buyCarService.findShopIdByGroupShopId(ids, Constants.USER_SESSION.getUserId());
        System.out.println(shopIds.length);
        for (int shopId : shopIds) {
            List<Buycar> list = buyCarService.findBuycarByShopId(shopId, Constants.USER_SESSION.getUserId());//拆分后的购物车信息
            //拆分后的订单总价
            double totalPrice = 0;
            Integer[] sIds = new Integer[list.size()];//需要从购物车移出的购物车ID
            for (int i=0;i<list.size();i++){
                //计算拆分后的订单总价=每个商品单价*数量，累加求和
                double price = list.get(i).getProduct().getIsPrice() == 1 ? list.get(i).getProduct().getNewPrice() : list.get(i).getProduct().getProPrice();//商品单价
                totalPrice += price * list.get(i).getNum();
                sIds[i] = list.get(i).getBuyCarId();
            }
            //生成订单
            Order order = new Order();
            order.setUser(Constants.USER_SESSION);
            order.setRecAddress(Constants.USER_SESSION.getRecAddresses().get(0));
            order.setCost(totalPrice);
            order.setOrderNum(Constants.getNumber());//订单编号
            int orderId = orderService.addOrder(order);
            if (orderId > 0){
                //3.向订单详情表插入数据（商品价格转为冻结金额），未成功插入：3
                List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
                List<Product> products = new ArrayList<Product>(); //保存需要修改的商品
                for (Buycar buycar : list) {
                    //2.向订单详情表插入数据，未成功插入：2
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
                            if (buyCarService.deleteBuyCarById(sIds)){
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
        }
        return choose;
    }*/

    //收货
    @RequestMapping("/doTakeGoods")
    public String doTakeGoods(@RequestParam(value = "orderIds") List<Integer> orderIds){
        Integer[] ids = orderIds.toArray(new Integer[orderIds.size()]);
        //1改变订单状态
        int num1 = orderService.modifyStatusByUserId(ids, 3, Constants.USER_SESSION.getUserId());
        //2将冻结金额转至卖家余额
        boolean flag = orderDetailService.modifyUserMoneyByOrderId(ids, Constants.USER_SESSION.getUserId());
        //3订单详情表的冻结金额清0
        int count = orderDetailService.modifyFrozenPrice(ids, 0);
        return "redirect:/userManager/userOrder";
    }





}
