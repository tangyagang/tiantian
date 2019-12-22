package com.cssl.tiantian.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Order implements Serializable {

    private static final long serialVersionUID = -4803196165576670698L;
    private int orderId;
    private User user;
    private RecAddress recAddress;
    private Date createTime;
    private double cost;
    private int status;
    private int paymentType;
    private String orderNum;
    private int scoreStatus;

    private List<ProScore> proScores;
    private List<OrderDetail> orderDetails;

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

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RecAddress getRecAddress() {
        return recAddress;
    }

    public void setRecAddress(RecAddress recAddress) {
        this.recAddress = recAddress;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public int getScoreStatus() {
        return scoreStatus;
    }

    public void setScoreStatus(int scoreStatus) {
        this.scoreStatus = scoreStatus;
    }
}
