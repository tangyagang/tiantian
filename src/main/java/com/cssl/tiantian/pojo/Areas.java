package com.cssl.tiantian.pojo;

import java.io.Serializable;
import java.util.List;

public class Areas implements Serializable {

    private static final long serialVersionUID = 1867036497670082990L;
    private int areaId;
    private int areaCode;
    private String area;
    private Cities cities;

    private List<User> users;
    private List<RecAddress> recAddresses;

    public List<RecAddress> getRecAddresses() {
        return recAddresses;
    }

    public void setRecAddresses(List<RecAddress> recAddresses) {
        this.recAddresses = recAddresses;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Cities getCities() {
        return cities;
    }

    public void setCities(Cities cities) {
        this.cities = cities;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
