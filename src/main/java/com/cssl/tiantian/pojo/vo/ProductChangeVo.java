package com.cssl.tiantian.pojo.vo;

import java.io.Serializable;

public class ProductChangeVo implements Serializable {

    private static final long serialVersionUID = 1516538691633239981L;
    private int proId;
    private String proName;
    private String description;
    private double proPrice;
    private int stock;
    private int pcId;
    private String proUrl;
    private int isPrice;
    private double newPrice;

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getPcId() {
        return pcId;
    }

    public void setPcId(int pcId) {
        this.pcId = pcId;
    }

    public String getProUrl() {
        return proUrl;
    }

    public void setProUrl(String proUrl) {
        this.proUrl = proUrl;
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
