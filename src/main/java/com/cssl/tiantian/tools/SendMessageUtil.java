package com.cssl.tiantian.tools;
/**
 * 有问题，暂时不用
 */

import java.io.IOException;
import java.io.InputStream;
import java.security.ProtectionDomain;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.qcloud.Utilities.Json.JSONException;



public class SendMessageUtil {
    //private static final String SMS_Url = "http://sms.webchinese.cn/web_api/";
    // 短信应用SDK AppID
    private static final int appid = 1400176564; // 1400开头
    // 短信应用SDK AppKey
    private static final String appkey = "8756f396474bb7d02fa616bbd056d385";

    // 需要发送短信的手机号码
   //private static final String[] phoneNumbers = {"18674814289"};

    // 短信模板ID，需要在短信应用中申请
    private static final int templateId = 267063; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请
    // templateId7839对应的内容是"您的验证码是: {1}"
    // 签名
    private static final String smsSign = "Leo技术交流";// NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`

    /**
     *
     * @param phoneNumbers 短信发送目标号码
     * @param RandomCode 随机验证码
     * @param time 有效时间
     * @return
     */
    public static String send(String[] phoneNumbers,String RandomCode,String time) {
        try {
            String[] params = {RandomCode, time};// 数组具体的元素个数和模板中变量个数必须一致，例如事例中templateId:5678对应一个变量，参数数组中元素个数也必须是一个
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[0], templateId, params, smsSign, "",""); // 签名参数未提供或者为空时，会使用默认签名发送短信
            System.out.println(result);
            return result.errMsg;
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }
        return "fail";//发送失败
    }
    /**
     * 随机生成6位验证码
     * @return
     */
    public static String getRandomCode(Integer code){
        Random random = new Random();
        StringBuffer result= new StringBuffer();
        for (int i=0;i<code;i++){
            result.append(random.nextInt(10));
        }
        return result.toString();
    }

    /**
     * 获取设置的过期时间
     * @return
     */
    public static String getOverdueSeconds(){
        //获取设置的过期时间
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        InputStream in = cl.getResourceAsStream("sms.properties");
        Properties dataproperties = new Properties();
        try {
            dataproperties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String overdueSeconds = dataproperties.getProperty("overdueSeconds").toString();
        int num = Integer.parseInt(overdueSeconds);
        int minute = num >=60 ? num/60 : 1;//秒钟转换成分钟
        return String.valueOf(minute);
    }

    /**
     * 获取时间差：秒（短信验证码超时用）
     * @param startDate
     * @param endDate
     * @return
     */
    public static long getDatePoor(Date startDate , Date endDate){
        long interval = (endDate.getTime() - startDate.getTime())/1000;
        System.out.println("两个时间相差"+interval+"秒");//会打印出相差?秒
        return interval;
    }
}
