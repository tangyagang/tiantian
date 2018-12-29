package com.cssl.tiantian.pojo;

import java.io.Serializable;
import java.util.List;

public class Provinces implements Serializable {

    private static final long serialVersionUID = -7996939334711333245L;
    private int provinceId;
    private int provinceCode;
    private String province;

    private List<Cities> citieses;

    public List<Cities> getCitieses() {
        return citieses;
    }

    public void setCitieses(List<Cities> citieses) {
        this.citieses = citieses;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
