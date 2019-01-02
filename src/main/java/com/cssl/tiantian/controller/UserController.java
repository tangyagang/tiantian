package com.cssl.tiantian.controller;

import com.cssl.tiantian.pojo.Product;
import com.cssl.tiantian.pojo.Provinces;
import com.cssl.tiantian.pojo.User;
import com.cssl.tiantian.service.product.ProductService;
import com.cssl.tiantian.service.provinces.ProvincesService;
import com.cssl.tiantian.service.user.UserService;
import com.cssl.tiantian.tools.RandomValidateCodeUtil;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProvincesService provincesService;

    @RequestMapping("/基本资料")
    public String user(ModelMap modelMap){
        User user = userService.findUserByUserId(1);
        List<Provinces> addressList = provincesService.findAll();
        modelMap.put("user",user);
        modelMap.put("addressList",addressList);
        return "基本资料";
    }

    /**
     * 生成验证码
     */
    @RequestMapping(value = "/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            e.printStackTrace();
            /* logger.error("获取验证码失败>>>>   ", e);*/
        }
       // return "基本资料";
    }

    //核对验证码
    @RequestMapping(value="validImage",method=RequestMethod.GET)
    public String validImage(HttpServletRequest request,HttpSession session){
        String code = request.getParameter("code");
        Object verCode = session.getAttribute("verCode");
        if (null == verCode) {
            request.setAttribute("errmsg", "验证码已失效，请重新输入");
            return "验证码已失效，请重新输入";
        }
        String verCodeStr = verCode.toString();
        LocalDateTime localDateTime = (LocalDateTime)session.getAttribute("codeTime");
        long past = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long now = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        if(verCodeStr == null || code == null || code.isEmpty() || !verCodeStr.equalsIgnoreCase(code)){
            request.setAttribute("errmsg", "验证码错误");
            return "验证码错误";
        } else if((now-past)/1000/60>5){
            request.setAttribute("errmsg", "验证码已过期，重新获取");
            return "验证码已过期，重新获取";
        } else {
            //验证成功，删除存储的验证码
            session.removeAttribute("verCode");
            return "200";
        }
    }


}
