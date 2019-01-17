package com.cssl.tiantian.message;
/**
 * 测试用
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class t2 {
    public static void main(String[] args){
        try {
            Date a = new Date();
            Thread.sleep(5000);
            Date b = new Date();
            long interval = (b.getTime() - a.getTime())/1000;
            System.out.println("两个时间相差"+interval+"秒");//会打印出相差3秒
        } catch (InterruptedException e) {
            e.printStackTrace();  }
    }

}
