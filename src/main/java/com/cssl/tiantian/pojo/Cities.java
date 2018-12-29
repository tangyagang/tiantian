package com.cssl.tiantian.pojo;

import java.io.Serializable;
import java.util.List;

public class Cities implements Serializable {

    private static final long serialVersionUID = 852383620930899009L;
    private int cityId;
    private int cityCode;
    private String city;
    private Provinces provinces;

    private List<Areas> areases;

    public List<Areas> getAreases() {
        return areases;
    }

    public void setAreases(List<Areas> areases) {
        this.areases = areases;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Provinces getProvinces() {
        return provinces;
    }

    public void setProvinces(Provinces provinces) {
        this.provinces = provinces;
    }
}
