package com.cssl.tiantian.controller.userManager;

import com.cssl.tiantian.pojo.Product;
import com.cssl.tiantian.service.product.ProductService;
import com.cssl.tiantian.tools.Constants;
import com.cssl.tiantian.tools.HistoryList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/userManager")
public class MyHistoryController {

    @Resource
    private ProductService productService;


    //浏览足迹，从客户端读取浏览的商品
    @RequestMapping("/myHistory")
    public String getQueryProduct(ModelMap modelMap,HttpServletRequest request){
        List<Product> list = queryHistory(request);
        modelMap.put("user", Constants.USER_SESSION);//用户信息
        modelMap.put("list", list);
        return "/userManager/myHistory";
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
}
