package com.cssl.tiantian.tools;
/**
 * 从客户端读取浏览的商品
 */

import com.cssl.tiantian.pojo.Product;
import com.cssl.tiantian.service.product.ProductService;
import com.cssl.tiantian.service.product.ProductServiceImp;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class HistoryList {

    private ProductService ps = new ProductServiceImp();

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
            String[] proIds = value.split(",");
            for (String proId : proIds) {
                Product product = ps.findProductByProId(Integer.parseInt(proId));
                historyList.add(product);
            }
        }
        return historyList;
    }
}
