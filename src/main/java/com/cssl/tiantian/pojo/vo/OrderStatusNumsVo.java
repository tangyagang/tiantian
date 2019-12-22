package com.cssl.tiantian.pojo.vo;

import java.io.Serializable;

public class OrderStatusNumsVo implements Serializable {

    private int num0;//所有订单
    private int num1;//待发货
    private int num2;//待收货
    private int num3;//待评价

    public int getNum0() {
        return num0;
    }

    public void setNum0(int num0) {
        this.num0 = num0;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getNum3() {
        return num3;
    }

    public void setNum3(int num3) {
        this.num3 = num3;
    }

    public OrderStatusNumsVo() {
    }

    public OrderStatusNumsVo(int num0, int num1, int num2, int num3) {
        this.num0 = num0;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }
}
