package com.cssl.tiantian.pojo;

import java.io.Serializable;
import java.util.List;

public class ProductCategory implements Serializable {

    private static final long serialVersionUID = -3212952911119111636L;
    //菜单ID
    private int pcId;
    //菜单名称
    private String pcName;
    //父菜单ID
    private int parentId;
    //子菜单
    private List<ProductCategory> productCategorys;
    private int typeId;

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getPcId() {
        return pcId;
    }

    public void setPcId(int pcId) {
        this.pcId = pcId;
    }

    public String getPcName() {
        return pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public List<ProductCategory> getProductCategorys() {
        return productCategorys;
    }

    public void setProductCategorys(List<ProductCategory> productCategorys) {
        this.productCategorys = productCategorys;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
