package com.cssl.tiantian.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 全局日期处理类
 * Created by Administrator on 2017/6/4 0004.
 */
@Component
public class DateConverter implements Converter<String,Date> {

    public Date convert(String source) {
        Date date = null;
        try {
            //1. 定义日期格式
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ");

            //2. 解析日期
            date = format.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}

