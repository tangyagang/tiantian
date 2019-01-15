package com.cssl.tiantian.tools;

import com.cssl.tiantian.pojo.User;

import java.util.Random;

public class Constants {
    public static User USER_SESSION;//用户保存信息
    public final static String MESSAGE="message";//信息提示
    public final static int PAGE_SIZE = 4;//每页显示商品数量
    public final static int HISTORY_MAX = 5;//商品浏览记录最大显示数量
    public final static String UPLOAD = "img/upload/";

    //生成唯一的编号
    public static String getNumber(){
        long time = System.currentTimeMillis();
        int rand = new Random().nextInt(1000);
        String number = String.valueOf(time)+rand;
        return number;
    }
}
