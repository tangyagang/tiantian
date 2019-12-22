package com.cssl.tiantian.pojo.vo;



import java.io.Serializable;
import java.sql.Date;


public class RecAddressAddVo implements Serializable {

    private static final long serialVersionUID = 8141866412904412822L;
    private int recAddressId;
    private int userId;
    private int areaId;
    private String recName;
    private String recAddress;
    private String addressCode;
    private String phone;
    private Date createTime;
    private int isDefault;

    public int getRecAddressId() {
        return recAddressId;
    }

    public void setRecAddressId(int recAddressId) {
        this.recAddressId = recAddressId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
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

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
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
