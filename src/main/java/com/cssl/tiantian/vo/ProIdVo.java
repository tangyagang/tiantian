package com.cssl.tiantian.vo;

public class ProIdVo {
    int proId; //这是商品添加方法返回的ID
    private int proImgId;
    private String proImgUrl;
    int shopId;

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getProImgId() {
        return proImgId;
    }

    public void setProImgId(int proImgId) {
        this.proImgId = proImgId;
    }



    public String getProImgUrl() {
        return proImgUrl;
    }

    public void setProImgUrl(String proImgUrl) {
        this.proImgUrl = proImgUrl;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }
}
