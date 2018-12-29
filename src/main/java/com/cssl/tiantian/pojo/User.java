package com.cssl.tiantian.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class User implements Serializable {

    private static final long serialVersionUID = -3384071261794990175L;
    private int userId;
    private String userName;
    private String password;
    private int userType;
    private String nickName;
    private String realName;
    private int sex;
    private String phone;
    private String email;
    private Date birthday;
    private String identity;
    private String userUrl;
    private Double money;
    private int integra;
    private String address;
    //一对多
    private List<Shop> shops;
    private List<RecAddress> recAddresses;
    private List<ProScore> proScores;
    private List<Order> orders;

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }

    public List<RecAddress> getRecAddresses() {
        return recAddresses;
    }

    public void setRecAddresses(List<RecAddress> recAddresses) {
        this.recAddresses = recAddresses;
    }

    public List<ProScore> getProScores() {
        return proScores;
    }

    public void setProScores(List<ProScore> proScores) {
        this.proScores = proScores;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public int getIntegra() {
        return integra;
    }

    public void setIntegra(int integra) {
        this.integra = integra;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
