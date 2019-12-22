package com.cssl.tiantian.controller.userManager;

import com.cssl.tiantian.pojo.Order;
import com.cssl.tiantian.pojo.Page;
import com.cssl.tiantian.pojo.ProScore;
import com.cssl.tiantian.pojo.User;
import com.cssl.tiantian.pojo.vo.ProScoreNumsVo;
import com.cssl.tiantian.pojo.vo.ProScoreVo;
import com.cssl.tiantian.pojo.vo.ScoreSearch;
import com.cssl.tiantian.service.order.OrderService;
import com.cssl.tiantian.service.proScore.ProScoreService;
import com.cssl.tiantian.service.user.UserService;
import com.cssl.tiantian.tools.Constants;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/userManager")
public class ProScoreController {

    @Resource
    private OrderService orderService;
    @Resource
    private ProScoreService proScoreService;
    @Resource
    private UserService userService;

    @RequestMapping("/reviews")
    public String toReviews(int orderId, ModelMap modelMap){
        Order order = orderService.findOrderById(orderId);
        modelMap.put("order", order);
        modelMap.put("user", Constants.USER_SESSION);//用户信息
        return "/userManager/reviews";
    }

    //添加评论
    @RequestMapping("/addScore")
    public String addScore(ProScoreVo proScoreVo,ModelMap modelMap){
        proScoreVo.setUserId(Constants.USER_SESSION.getUserId());
        if (proScoreService.addProScore(proScoreVo) > 0){
            return "redirect:/userManager/userOrder";
        }
        modelMap.put("message", "添加失败请检查输入内容！");
        return "forward:/userManager/reviews?orderId="+proScoreVo.getOrderId();
    }

    //跳转到评论管理
    @RequestMapping("/proScore")
    public String toProScore(@RequestParam(value = "pageNo",required = false)String pageNo,
                             @RequestParam(value = "scoreString",required = false)String scoreString,
                             @RequestParam(value = "isDetails",required = false)String isDetails,
                             ModelMap modelMap){
        ScoreSearch scoreSearch = new ScoreSearch();
        if (scoreString != null && scoreString != ""){
            modelMap.put("scoreString", scoreString);
            String[] str = scoreString.split("-");
            scoreSearch.setStartScore(str[0]);
            scoreSearch.setEndScore(str[1]);
        }
        if (scoreString != null && scoreString != ""){
            modelMap.put("isDetails", isDetails);
            scoreSearch.setIsDetails(Integer.parseInt(isDetails));
        }

        Integer pn = pageNo != null && !pageNo.equals("") ? Integer.parseInt(pageNo) : 1;//当前页码
        PageInfo<ProScore> pageInfo = proScoreService.findAllByUserId(scoreSearch,Constants.USER_SESSION.getUserId(), pn, Constants.PAGE_SIZE);
        int[] numbs = Page.getPageNumbers(pn, pageInfo.getPages());
        List<ProScore> list = proScoreService.findAllByUserId(new ScoreSearch(),Constants.USER_SESSION.getUserId());
        int weekNumLow = 0;
        int monthNumLow = 0;
        int yearNumLow = 0;
        int halfYearNumLow = 0;

        int weekNumMid = 0;
        int monthNumMid = 0;
        int yearNumMid = 0;
        int halfYearNumMid = 0;

        int weekNumHigh = 0;
        int monthNumHigh = 0;
        int yearNumHigh = 0;
        int halfYearNumHigh = 0;
        for (ProScore proScore : list) {
            int score = proScore.getScore();//评分
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            Date createTime = proScore.getCreateTime();//创建时间
            String createTimeStr = df.format(createTime);
            if (proScore.getScore() >= 0 && proScore.getScore() <= 30){
                //差评
                if ( getPastDate(createTimeStr) != null && getPastDate(createTimeStr) != ""){
                    if (getPastDate(createTimeStr).equals("weekNum")){
                        weekNumLow++;
                    }else if (getPastDate(createTimeStr).equals("monthNum")){
                        monthNumLow++;
                    }else if (getPastDate(createTimeStr).equals("halfYearNum")){
                        halfYearNumLow++;
                    }else {
                        yearNumLow++;
                    }
                }
            }else if (proScore.getScore() > 30 && proScore.getScore() <= 60){
                //中评
                if (getPastDate(createTimeStr) != null && getPastDate(createTimeStr) != ""){
                    if (getPastDate(createTimeStr).equals("weekNum")){
                        weekNumMid++;
                    }else if (getPastDate(createTimeStr).equals("monthNum")){
                        monthNumMid++;
                    }else if (getPastDate(createTimeStr).equals("halfYearNum")){
                        halfYearNumMid++;
                    }else {
                        yearNumMid++;
                    }
                }
            }else {
                //好评
                if (getPastDate(createTimeStr) != null && getPastDate(createTimeStr) != ""){
                    if (getPastDate(createTimeStr).equals("weekNum")){
                        weekNumHigh++;
                    }else if (getPastDate(createTimeStr).equals("monthNum")){
                        monthNumHigh++;
                    }else if (getPastDate(createTimeStr).equals("halfYearNum")){
                        halfYearNumHigh++;
                    }else {
                        yearNumHigh++;
                    }
                }
            }
        }
        int totalNumLow = weekNumLow + monthNumLow + halfYearNumLow + yearNumLow;
        int totalNumMid = weekNumMid + monthNumMid + halfYearNumMid + yearNumMid;
        int totalNumHigh = weekNumHigh + monthNumHigh + halfYearNumHigh + yearNumHigh;
        ProScoreNumsVo scoreNumsVoLow = new ProScoreNumsVo(weekNumLow, monthNumLow, yearNumLow, halfYearNumLow, totalNumLow);
        ProScoreNumsVo scoreNumsVoMid = new ProScoreNumsVo(weekNumMid, monthNumMid, yearNumMid, halfYearNumMid, totalNumMid);
        ProScoreNumsVo scoreNumsVoHigh = new ProScoreNumsVo(weekNumHigh, monthNumHigh, yearNumHigh, halfYearNumHigh, totalNumHigh);
        User user = userService.findUserByUserId(Constants.USER_SESSION.getUserId());
        modelMap.put("pageInfo", pageInfo);
        modelMap.put("numbs", numbs);
        modelMap.put("user", user);
        modelMap.put("scoreNumsVoLow", scoreNumsVoLow);
        modelMap.put("scoreNumsVoMid", scoreNumsVoMid);
        modelMap.put("scoreNumsVoHigh", scoreNumsVoHigh);
        return "/userManager/proScore";
    }

    //获取日期区间
    public String getPastDate(String createTimeStr){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        //Date date = new Date();
        //String today = date.toString();//当前时间
        String today = df.format(new Date());//当前时间
        System.out.println(today);
        String week = PublicUser.getPastDate(7);//7天
        String month = PublicUser.getPastDate(30);//30天
        String halfYear = PublicUser.getPastDate(30*6);//30*6,半年

        try {
            if (PublicUser.hourMinuteBetween(createTimeStr, week, today)){
                //过去7天
                return "weekNum";
            }else if (PublicUser.hourMinuteBetween(createTimeStr, month, today)){
                //过去一个月
                return "monthNum";
            }else if (PublicUser.hourMinuteBetween(createTimeStr, halfYear, today)){
                //过去半年内
                return "halfYearNum";
            }else {
                //过去半年前
                return "yearNum";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
