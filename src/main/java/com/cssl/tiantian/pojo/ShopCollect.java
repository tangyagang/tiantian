package com.cssl.tiantian.pojo;

import java.io.Serializable;

public class ShopCollect implements Serializable {

    private static final long serialVersionUID = 3351793729749608611L;
    private int shopCollectId;
    private User user;
    private Product product;

    public int getShopCollectId() {
        return shopCollectId;
    }

    public void setShopCollectId(int shopCollectId) {
        this.shopCollectId = shopCollectId;
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
}
