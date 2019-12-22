package com.cssl.tiantian.pojo.vo;

import java.io.Serializable;

public class ProductModifyVo implements Serializable {

    private static final long serialVersionUID = 1516538691633239981L;
    private int proId;
    private double proPrice;
    private int stock;
    private int isPrice;
    private double newPrice;

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public double getProPrice() {
        return proPrice;
    }

    public void setProPrice(double proPrice) {
        this.proPrice = proPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getIsPrice() {
        return isPrice;
    }

    public void setIsPrice(int isPrice) {
        this.isPrice = isPrice;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }
}
