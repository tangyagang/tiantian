package com.cssl.tiantian.filter;

import com.cssl.tiantian.pojo.RecAddress;
import com.cssl.tiantian.pojo.User;
import com.cssl.tiantian.tools.Constants;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("开始执行过滤器...");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //暂时做个假的登录
       /* User user = new User();
        RecAddress recAddress = new RecAddress();
        recAddress.setRecAddressId(3);
        user.setUserId(4);
        user.setMoney(10000000.0);
        user.setUserUrl("/img/upload/userUpload//49f7b3e8c4b94db495d07d20c859f1b3.jpg");
        List<RecAddress> list = new ArrayList<RecAddress>();
        list.add(recAddress);
        user.setRecAddresses(list);
        Constants.USER_SESSION = user;*/
        //////////////////
        //设置请求的字符集

        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("结束执行过滤器...");
    }
}
