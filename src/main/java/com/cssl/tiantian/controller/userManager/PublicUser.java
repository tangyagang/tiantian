package com.cssl.tiantian.controller.userManager;
/**
 * 公共部分
 */

import com.cssl.tiantian.pojo.Order;
import com.cssl.tiantian.pojo.Product;
import com.cssl.tiantian.pojo.vo.OrderStatusNumsVo;
import com.cssl.tiantian.service.product.ProductService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Controller
public class PublicUser {

    @Resource
    private ProductService productService;

    //获取订单状态的数量
    public OrderStatusNumsVo getOrderStatusNums(List<Order> list){
        int num0 = 0;//所有订单
        int num1 = 0;//待发货
        int num2 = 0;//待收货
        int num3 = 0;//待评价
        for (int i=0;i<list.size();i++){
            Order order = list.get(i);
            num0++;
            if (order.getStatus()==1){
                num1++;
            }else if (order.getStatus()==2){
                num2++;
            }else {
                num3++;
            }
        }
        OrderStatusNumsVo orderStatusNums = new OrderStatusNumsVo(num0,num1,num2,num3);
        return orderStatusNums;
    }

    /**
     * 从客户端读取浏览的商品
     */
    public List<Product> queryHistory(HttpServletRequest request){
        Cookie[] cks = request.getCookies();
        Cookie cookie = null;
        if (cks != null && cks.length > 0){
            for (Cookie ck : cks) {
                if(ck.getName().equals("history")){
                    cookie = ck;
                    break;
                }
            }
        }
        List<Product> historyList = new ArrayList<Product>();
        if (cookie != null && !cookie.equals("")){
            //有浏览记录
            String value = cookie.getValue();
            String[] proIds = value.split("#");
            for (String proId : proIds) {
                Product product = productService.findProductByProId(Integer.parseInt(proId));
                historyList.add(product);
            }
        }
        return historyList;
    }

    /**
     *
     * @param nowDate   要比较的时间
     * @param startDate   开始时间
     * @param endDate   结束时间
     * @return   true在时间段内，false不在时间段内
     * @throws Exception
     */
    public static boolean hourMinuteBetween(String nowDate, String startDate, String endDate) throws Exception{

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Date now = format.parse(nowDate);
        Date start = format.parse(startDate);
        Date end = format.parse(endDate);

        long nowTime = now.getTime();
        long startTime = start.getTime();
        long endTime = end.getTime();

        return nowTime >= startTime && nowTime <= endTime;
    }

    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);//设置开始和结束时间
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String result = format.format(today);
        return result;
    }



}
