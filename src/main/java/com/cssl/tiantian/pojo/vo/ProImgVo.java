package com.cssl.tiantian.pojo.vo;


import java.io.Serializable;

public class ProImgVo implements Serializable {

    private static final long serialVersionUID = 8598930972416718336L;
    private int proImgId;
    private int proId;
    private String proImgUrl;
    private int shopId;

    public int getProImgId() {
        return proImgId;
    }

    public void setProImgId(int proImgId) {
        this.proImgId = proImgId;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getProImgUrl() {
        return proImgUrl;
    }

    public void setProImgUrl(String proImgUrl) {
        this.proImgUrl = proImgUrl;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }
}
