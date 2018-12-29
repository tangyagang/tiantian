package com.cssl.tiantian.pojo;

import java.io.Serializable;

public class ProImg implements Serializable {

    private static final long serialVersionUID = -3256650750348399298L;
    private int proImgId;
    private Product product;
    private String proImgUrl;
    private Shop shop;

    public int getProImgId() {
        return proImgId;
    }

    public void setProImgId(int proImgId) {
        this.proImgId = proImgId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getProImgUrl() {
        return proImgUrl;
    }

    public void setProImgUrl(String proImgUrl) {
        this.proImgUrl = proImgUrl;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
