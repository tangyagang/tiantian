package com.cssl.tiantian.tools;
/**
 * 浏览的商品记录
 */

import com.cssl.tiantian.pojo.Product;
import com.cssl.tiantian.service.product.ProductService;
import com.cssl.tiantian.service.product.ProductServiceImp;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class HistoryList {

    private ProductService ps = new ProductServiceImp();
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
            String[] proIds = value.split(",");
            for (String proId : proIds) {
                Product product = ps.findProductByProId(Integer.parseInt(proId));
                historyList.add(product);
            }
        }
        return historyList;
    }
    /**
     * 把当前商品的id，添加到cookie里面
     * @param proId
     * @param request
     * @param response
     */
    private void addHistory(String proId, HttpServletRequest request,
                            HttpServletResponse response){
        Cookie ck = null;
        Cookie[] cks = request.getCookies();
        if (cks != null && cks.length > 0){
            for (Cookie cookie : cks) {
                String key = cookie.getName();
                if(key.equals("history")){
                    ck = cookie;
                    break;
                }
            }
        }
        if (ck == null){
            //说明客户端不存在一个叫做history的cookie，就只能创建一个新的
            ck = new Cookie("history",proId);
        }else {
            String value = ck.getValue();
            String[] proIds = value.split(",");
            String[] newProIds = replaceProIds(proIds,proId);
            String idStr = "";
            for (String newProId : newProIds) {
                idStr += newProId+",";
            }
            idStr = idStr.substring(idStr.length()-1);
            ck.setValue(idStr);
        }
        ck.setMaxAge(60*60*27*7);//设置cookie的有效时间为7天
        response.addCookie(ck);
    }
    /**
     * 去掉数组中重复的值（id)，生成新的数组，把id放到新的数组的最前面
     * @param proIds
     * @param proId
     * @return
     */
    public String[] replaceProIds(String[] proIds, String proId){
        int index = -1;
        for (int i=0;i<proIds.length;i++){
            if (proIds[i].equals(proId)){
                index = i;
                break;
            }
        }
        if(index >= 0){
            //有重复，去掉重复 25,26,24,38    24
            proIds[index] = null;
            //移位，把index之前的数字依次往后移一位
            for (int i=index-1;i>=0;i--){
                String temp = proIds[i];//index前面一位
                proIds[i] = proIds[i+1];
                proIds[i+1] = temp;
            }
            //最后把本次的id添加到最前面
            proIds[0] = proId;
            return  proIds;
        }else {
            //没有重复
            if (proIds.length == 5){
                //达到最大数
                //去掉最后一位
                proIds[proIds.length-1] = null;
                //移位，把index之前的数字依次往后移一位
                for (int i=index-1;i>=0;i--){
                    String temp = proIds[i];//index前面一位
                    proIds[i] = proIds[i+1];
                    proIds[i+1] = temp;
                }
                //最后把本次的id添加到最前面
                proIds[0] = proId;
                return proIds;
            }else {
                //没有达到最大数
                String[] newProIds = new String[proIds.length+1];
                for (int i=0;i<proIds.length;i++){
                    newProIds[i+1] = proIds[i];
                }
                //最后把本次的id添加到最前面
                proIds[0] = proId;
                return newProIds;
            }
        }
    }
    /**
     * 检查id在ids中是否存在
     */
    /*private boolean exists(String[] ids,String id){
        boolean flag = false;
        for(String str : ids){
            if(str.equals(id)){
                flag = true;
            }
        }
        return flag;
    }*/
}
