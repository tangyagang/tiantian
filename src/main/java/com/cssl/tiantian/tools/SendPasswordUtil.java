package com.cssl.tiantian.tools;
/**
 * 发送密码用
 */

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.qcloud.Utilities.Json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import java.util.Random;


public class SendPasswordUtil {
    //private static final String SMS_Url = "http://sms.webchinese.cn/web_api/";
    // 短信应用SDK AppID
    private static final int appid = 1400176564; // 1400开头
    // 短信应用SDK AppKey
    private static final String appkey = "8756f396474bb7d02fa616bbd056d385";
    // 短信模板ID，需要在短信应用中申请
    private static final int templateId = 267841; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请
    // templateId7839对应的内容是"您的验证码是: {1}"
    // 需要发送短信的手机号码
   //private static final String[] phoneNumbers = {"18674814289"};

    // 短信模板ID，需要在短信应用中申请
    //private static final int templateId = 267063; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请
    // templateId7839对应的内容是"您的验证码是: {1}"
    // 签名
    private static final String smsSign = "Leo技术交流";// NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`

    /**
     *
     * @param phoneNumbers 短信发送目标号码
     * @param password 密码
     * @return
     */
    public static String sendPassword(String[] phoneNumbers,String password) {
        try {
            String[] params = {password};// 数组具体的元素个数和模板中变量个数必须一致，例如事例中templateId:5678对应一个变量，参数数组中元素个数也必须是一个
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
}
