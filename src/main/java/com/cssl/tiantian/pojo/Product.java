package com.cssl.tiantian.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Product implements Serializable {

    private static final long serialVersionUID = 1252052505732349211L;
    private int proId;
    private String proName;
    private String description;
    private double proPrice;
    private int stock;
    private ProductCategory productCategory;
    private String proUrl;
    private int isDelete;
    private int isPrice;
    private double newPrice;
    private Shop shop;
    private Date createTime;

    private List<ProImg> proImgs;
    private List<ProScore> proScores;
    private List<OrderDetail> orderDetails;

    public List<ProImg> getProImgs() {
        return proImgs;
    }

    public void setProImgs(List<ProImg> proImgs) {
        this.proImgs = proImgs;
    }

    public List<ProScore> getProScores() {
        return proScores;
    }

    public void setProScores(List<ProScore> proScores) {
        this.proScores = proScores;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

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

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getProUrl() {
        return proUrl;
    }

    public void setProUrl(String proUrl) {
        this.proUrl = proUrl;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
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

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
