package com.cssl.tiantian.pojo;

import java.io.Serializable;

public class Buycar implements Serializable {

    private static final long serialVersionUID = -397009044704792454L;
    private int buyCarId;
    private User user;
    private Product product;
    private int num;

    public int getBuyCarId() {
        return buyCarId;
    }

    public void setBuyCarId(int buyCarId) {
        this.buyCarId = buyCarId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
