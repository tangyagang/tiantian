package com.cssl.tiantian.vo;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SellFindVo {
    Integer orderNum;
    String proName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date createTime1;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date createTime2;
    //买家ID
    String userId;
    //卖家ID
    int shopId;

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Date getCreateTime1() {
        return createTime1;
    }

    public void setCreateTime1(Date createTime1) {
        this.createTime1 = createTime1;
    }

    public Date getCreateTime2() {
        return createTime2;
    }

    public void setCreateTime2(Date createTime2) {
        this.createTime2 = createTime2;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public SellFindVo() {
    }

    public SellFindVo(Integer orderNum, String proName, Date createTime1, Date createTime2, String userId, int shopId) {
        this.orderNum = orderNum;
        this.proName = proName;
        this.createTime1 = createTime1;
        this.createTime2 = createTime2;
        this.userId = userId;
        this.shopId = shopId;
    }
}
