package com.cssl.tiantian.interceptors;

import com.cssl.tiantian.pojo.User;
import com.cssl.tiantian.service.user.UserService;
import com.cssl.tiantian.service.user.UserServiceImpl;
import com.cssl.tiantian.tools.Constants;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 自定义拦截器
 */
@Component
@Controller
public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private UserService userService;

    /**
     * 在请求被处理之前调用
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器开始拦截...");
        // 检查每个到来的请求对应的session域中是否有登录标识
        //如果session中没有user，表示没登陆
        User user = (User)request.getSession().getAttribute("user");
        if (user == null){
            //这个方法返回false表示忽略当前请求，如果一个用户调用了需要登陆才能使用的接口，如果他没有登陆这里会直接忽略掉
            //当然你可以利用response给用户返回一些提示信息，告诉他没登陆
            //request.setAttribute("message","请先登录");
            response.sendRedirect(request.getContextPath()+"/login");
            //request.getRequestDispatcher("/login").forward(request, response);
            return false;
        }else {
            User user1 = userService.findUserByUserId(Constants.USER_SESSION.getUserId());
            Constants.USER_SESSION = user1;
            return true;    //如果session里有user，表示该用户已经登陆，放行，用户即可继续调用自己需要的接口
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截器结束执行...");
    }
}
