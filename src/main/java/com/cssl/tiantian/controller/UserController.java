package com.cssl.tiantian.controller;

import com.cssl.tiantian.pojo.User;
import com.cssl.tiantian.service.areas.AreasService;
import com.cssl.tiantian.service.product.ProductService;
import com.cssl.tiantian.service.provinces.ProvincesService;
import com.cssl.tiantian.service.user.UserService;
import com.cssl.tiantian.authImage.RandomValidateCodeUtil;
import com.cssl.tiantian.tools.Constants;
import com.cssl.tiantian.tools.SendMessageUtil;
import com.cssl.tiantian.tools.SendPasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.time.LocalDateTime;
import java.sql.Date;
import java.util.*;

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
<<<<<<< HEAD
            request.getSession().setAttribute("user", Constants.USER_SESSION);
=======
            request.getSession().setAttribute("User",user);
>>>>>>> github/master
            if (user.getUserType()==1){
                //买家
                return "redirect:/userManager/userIndex";
            }else if (user.getUserType()==2){
                //卖家
<<<<<<< HEAD
                return "redirect:/adminManager/orderList";
=======
                return "forward:/sellManager/SellOrder";
>>>>>>> github/master
            }else {
                //超级管理员
                return "redirect:/superManager/superOrderList";
            }
        }
        return "redirect:/login";
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
    //发送手机验证码
    @RequestMapping("/sendMessage")
    @ResponseBody
    public Map<String,Object> sendMessage(@RequestParam("phone") String phone,HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map = new  HashMap<String,Object>();
        String time = SendMessageUtil.getOverdueSeconds();//验证码超时时间,单位分钟
        //先判断手机号是否注册
        if (phone==null){
            //获取手机号失败
            map.put("success", false);
            map.put("msg", "获取手机号失败");
            return map;
        }
        HttpSession session = request.getSession();
        //获取四位随机数
        String  randomCode = SendMessageUtil .getRandomCode(4);
        // 需要发送短信的手机号码
        String[] phoneNumbers = {phone};
        String result = null;
        try {
            result = SendMessageUtil.send(phoneNumbers,randomCode,time);
            System.out.println(result);
            if ("ok".equalsIgnoreCase(result)){//发送成功
                session.setAttribute(phone,randomCode);//以手机号为键,随机数为值
                //以手机号+Time为键,保存发送短信时间,用于判断是否过期
                session.setAttribute(phone + "time", new java.util.Date());
                System.out.println(session.getAttribute(phone)+"时间"+session.getAttribute(phone));
                map.put("success", true);
                map.put("msg", "发送成功");
                return map;
            }else{//发送失败
                System.out.println("发送短信失败:"+result.toString());
                map.put("success", false);
                map.put("msg", "手机号频率限制，发送失败");
                return map;
            }
            //TimerTask实现5分钟后从session中删除code
            /*final Timer timer=new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if ( session.getAttribute(phone)!=null){
                        session.removeAttribute(phone);
                    }
                    System.out.println(phone+"验证码删除成功");
                    timer.cancel();
                }
            },time*60*1000);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(session.getAttribute(phone));
        return map;
    }

    //2.校验短信是否超时
    /**
     *
     * @param phone
     * @param code 验证码
     * @param session
     * @return
     */
    @RequestMapping("/checkMessage")
    @ResponseBody
    public Map<String, Object> checkVerificationCode(String phone, String code, HttpSession session) {
        Map<String,Object> map = new HashMap<String,Object>();
        if(session != null){
            //根据手机号拿到验证码
            Object sessVerificationCode = session.getAttribute(phone);
            if(sessVerificationCode == null){
                map.put("success", false);
                map.put("msg", "请先获取验证码");
                System.out.println("该手机号未获取过验证码,故而取不到验证码,手机号为"+phone);
                return map;
            }
            if(sessVerificationCode.equals(code)){//服务端保存的验证码和用户输入验证码比较
                //判断验证码是否过期
                java.util.Date sendTime = (java.util.Date)session.getAttribute(phone+"time");//发送短信时间
                //判断和当前时间相差多少秒
                Long seconds = SendMessageUtil.getDatePoor(sendTime, new java.util.Date());
                System.out.println("手机号" + phone +"相差" +seconds +"秒");
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
                //如果相差秒数大于设置的过期秒数就是过期了
                if(seconds > Long.parseLong(overdueSeconds)){
                    map.put("success", false);
                    map.put("msg", "验证码已过期");
                    session.removeAttribute(phone+"time");
                    System.out.println("短信验证码已过期,手机号为"+phone);
                    return map;
                }else{
                    map.put("success", true);
                    map.put("msg", "验证成功");
                    System.out.println("短信验证码验证成功,手机号为"+phone);
                    return map;
                }
            }else{//验证码错误
                map.put("success", false);
                map.put("msg", "验证码不正确");
                System.out.println("用户输入验证码不正确,手机号为"+phone);
                return map;
            }
        }
        return map;
    }

    @RequestMapping("/sendPassword")
    @ResponseBody
    public Map<String,Object> sendPassword(@RequestParam("phone") String phone){
        Map<String,Object> map = new HashMap<String,Object>();
        User user = userService.findUserByPhone(phone);
        if (user != null){
            // 需要发送短信的手机号码
            String[] phoneNumbers = {phone};
            String password = user.getPassword();
            String result = SendPasswordUtil.sendPassword(phoneNumbers,password);
            System.out.println(result);
            if ("ok".equalsIgnoreCase(result)){
                //发送成功
                map.put("success", true);
                map.put("msg", "验证成功");
                System.out.println("短信验证码验证成功,手机号为"+phone);
                return map;
            }else {
                System.out.println("发送短信失败:"+result.toString());
                map.put("success", false);
                map.put("msg", "发送失败");
                return map;
            }
        }
        map.put("success", false);
        map.put("msg", "该手机号码暂未注册！");
        return map;
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

    //退出登录
    @RequestMapping("/exit")
    public String exit(@RequestParam(value = "msg",required = false)String msg, HttpServletRequest request){
        request.getSession().removeAttribute("user");
        if(!"".equals(msg) && msg != null){
            return "redirect:/"+msg;
        }
        return "redirect:/login";
    }


}
