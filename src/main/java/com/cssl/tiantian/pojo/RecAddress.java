package com.cssl.tiantian.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class RecAddress implements Serializable {

    private static final long serialVersionUID = 4886540335267049673L;
    private int recAddressId;
    private User user;
    private Areas areas;
    private String recName;
    private String recAddress;
    private String addressCode;
    private String phone;
    private Date createTime;
    private int isDefault;

    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public int getRecAddressId() {
        return recAddressId;
    }

    public void setRecAddressId(int recAddressId) {
        this.recAddressId = recAddressId;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Areas getAreas() {
        return areas;
    }

    public void setAreas(Areas areas) {
        this.areas = areas;
    }

    public String getRecName() {
        return recName;
    }

    public void setRecName(String recName) {
        this.recName = recName;
    }

    public String getRecAddress() {
        return recAddress;
    }

    public void setRecAddress(String recAddress) {
        this.recAddress = recAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }
}
