package com.cssl.tiantian.pojo;

import java.io.Serializable;
import java.util.List;

public class Shop implements Serializable {

    private static final long serialVersionUID = -1992986035193157033L;
    private int shopId;
    private String shopName;
    private User user;
    private String address;

    private List<Product> products;
    private List<ProImg> proImgs;
    private List<OrderDetail> orderDetails;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<ProImg> getProImgs() {
        return proImgs;
    }

    public void setProImgs(List<ProImg> proImgs) {
        this.proImgs = proImgs;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
