package com.cssl.tiantian.pojo.vo;

import java.io.Serializable;

public class SuperOrderListSearch implements Serializable {

    private static final long serialVersionUID = -7419468950286374813L;
    private String proName;
    private String orderNum;
    private String userName;
    private String shopName;

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
