package com.cssl.tiantian.filter;

import com.cssl.tiantian.pojo.RecAddress;
import com.cssl.tiantian.pojo.User;
import com.cssl.tiantian.tools.Constants;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("开始执行过滤器...");
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html;charset=UTF-8");
        //暂时做个假的登录
        User user = new User();
        RecAddress recAddress = new RecAddress();
        recAddress.setRecAddressId(3);
        user.setUserId(2);
        user.setMoney(10000000.0);
        List<RecAddress> list = new ArrayList<RecAddress>();
        list.add(recAddress);
        user.setRecAddresses(list);
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //////////////////
        Constants.USER_SESSION = user;
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("结束执行过滤器...");
    }
}
