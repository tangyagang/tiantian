package com.cssl.tiantian.pojo;

import java.io.Serializable;

public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1417695124125789051L;
    private int odId;
    private Order order;
    private Product product;
    private int count;
    private double cost;
    private Shop shop;
    private double frozenPrice;
    private double dPrice;

    public int getOdId() {
        return odId;
    }

    public void setOdId(int odId) {
        this.odId = odId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public double getFrozenPrice() {
        return frozenPrice;
    }

    public void setFrozenPrice(double frozenPrice) {
        this.frozenPrice = frozenPrice;
    }

    public double getdPrice() {
        return dPrice;
    }

    public void setdPrice(double dPrice) {
        this.dPrice = dPrice;
    }
}
