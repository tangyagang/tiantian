package com.cssl.tiantian.pojo;

import java.io.Serializable;

public class ProductCollect implements Serializable {

    private static final long serialVersionUID = -7318537420086121225L;
    private int productCollectId;
    private User user;
    private Product product;

    public int getProductCollectId() {
        return productCollectId;
    }

    public void setProductCollectId(int productCollectId) {
        this.productCollectId = productCollectId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
