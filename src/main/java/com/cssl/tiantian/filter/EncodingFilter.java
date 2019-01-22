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
        User user = new User();
        RecAddress recAddress = new RecAddress();
        recAddress.setRecAddressId(3);
        user.setUserId(2);
        user.setMoney(10000000.0);
        user.setUserUrl("img/upload//d71c47ed6d314d9993f0943baf1e69b4.PNG");
        List<RecAddress> list = new ArrayList<RecAddress>();
        list.add(recAddress);
        user.setRecAddresses(list);
        Constants.USER_SESSION = user;
        //////////////////
        //设置请求的字符集

        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("结束执行过滤器...");
    }
}
