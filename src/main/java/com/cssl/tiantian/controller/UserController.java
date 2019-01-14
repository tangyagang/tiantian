package com.cssl.tiantian.controller;

import com.cssl.tiantian.pojo.Areas;
import com.cssl.tiantian.pojo.Provinces;
import com.cssl.tiantian.pojo.User;
import com.cssl.tiantian.service.areas.AreasService;
import com.cssl.tiantian.service.product.ProductService;
import com.cssl.tiantian.service.provinces.ProvincesService;
import com.cssl.tiantian.service.user.UserService;
import com.cssl.tiantian.authImage.RandomValidateCodeUtil;
import com.cssl.tiantian.tools.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLDecoder;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Controller
public class UserController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProvincesService provincesService;
    @Autowired
    private AreasService areasService;

    //验证登录
    @RequestMapping("/doLogin")
    public String login(@RequestParam("userName")String userName,
                        @RequestParam("password")String password,
                        HttpServletRequest request){
        User user = userService.loginUser(userName,password);
        if (user != null){
            //登录成功
            Constants.USER_SESSION = user;
            if (user.getUserType()==1){
                //买家
                return "userManager/userIndex";
            }else if (user.getUserType()==2){
                //卖家
                return "adminManager/adminIndex";
            }else {
                //超级管理员
                return "superManager/superIndex";
            }
        }
        return "login";
    }
    //判断用户是否存在
    @RequestMapping("/isExistUser")
    @ResponseBody
    public String isExistUser(String userName){
        User user = userService.isExistUserName(userName);
        if (user != null){
            return "Y";
        }
        return "N";
    }
    //注册
    @RequestMapping(value = "/doRegister")
    @ResponseBody
    public int doRequest(@ModelAttribute("user")User user,@RequestParam(value = "strBirthday",required = false)String strBirthday){
        if(strBirthday != null && strBirthday != ""){
            Date brithday = Date.valueOf(strBirthday);
            user.setBirthday(brithday);
        }
        int count = userService.registerUser(user);
        return count;
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
    @RequestMapping(value="/validImage",method=RequestMethod.GET)
    @ResponseBody
    public String validImage(HttpServletRequest request,HttpSession session,@RequestParam("veryCode") String code){
       // String code = request.getParameter("veryCode");
        Object verCode = session.getAttribute("RANDOMVALIDATECODEKEY");
        if (null == verCode) {
            request.setAttribute("message", "验证码已失效，请重新输入");
            return "X";
        }
        String verCodeStr = verCode.toString();
        LocalDateTime localDateTime = (LocalDateTime)session.getAttribute("codeTime");
       /* long past = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long now = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();*/
        if(verCodeStr == null || code == null || code.isEmpty() || !verCodeStr.equalsIgnoreCase(code)){
            request.setAttribute("message", "验证码错误");
            return "N";
        } /*else if((now-past)/1000/60>5){
            request.setAttribute("message", "验证码已过期，重新获取");
            return "验证码已过期，重新获取";
        }*/ else {
            //验证成功，删除存储的验证码
            session.removeAttribute("RANDOMVALIDATECODEKEY");
            return "Y";
        }
    }


}
