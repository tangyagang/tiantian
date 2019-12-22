package com.cssl.tiantian.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Product implements Serializable {

    private static final long serialVersionUID = 1252052505732349211L;
    private int proId;
    private String proName;
    private String description;
    private double proPrice;
    private int stock;
    private ProductCategory productCategory;
    private String proUrl;
    private int isDelete;
    private int isPrice;
    private double newPrice;
    private Shop shop;
    private Date createTime;

    private List<ProImg> proImgs;
    private List<ProScore> proScores;
    private List<OrderDetail> orderDetails;


}
