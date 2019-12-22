package com.cssl.tiantian.controller.superManager;

import com.cssl.tiantian.pojo.Page;
import com.cssl.tiantian.pojo.User;
import com.cssl.tiantian.service.user.UserService;
import com.cssl.tiantian.tools.Constants;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/superManager")
public class UserListController {

    @Resource
    private UserService userService;

    //查询用户
    @RequestMapping("/superUserList")
    public String toSuperUserList(@RequestParam(value = "userId",required = false)Integer userId,
                                  @RequestParam(value = "userType",required = false)Integer userType,
                                  String pageNo,
                                  ModelMap modelMap){

        if (userId == null || "".equals(userId)) {
            userId = 0;
        }
        if (userType == null || "".equals(null)){
            userType = 0;
        }
        Integer pn = pageNo != null && !pageNo.equals("") ? Integer.parseInt(pageNo) : 1;//当前页码
        PageInfo pageInfo = userService.findUserByUserIdAndUserType(pn, 2, userId, userType);
        int[] numbs = Page.getPageNumbers(pn, pageInfo.getPages());
        modelMap.put("user", Constants.USER_SESSION);//用户信息
        modelMap.put("pageInfo", pageInfo);
        modelMap.put("numbs", numbs);
        modelMap.put("userId", userId);//用于传值到页面
        modelMap.put("userType",userType);//用于传值到页面
        return "/superManager/superUserList";
    }

    //修改
    @RequestMapping("/modifyUser")
    @ResponseBody
    public boolean modifyUser(@RequestParam(value = "userId")Integer userId,
                             @RequestParam(value = "userType",required = false)Integer userType,
                             @RequestParam(value = "integra",required = false)Integer integra){
        User user = new User();
        if (userType != null && !"".equals(userType))
            user.setUserType(userType);
        if (integra != null && !"".equals(integra))
            user.setIntegra(integra);
        user.setUserId(userId);
        if (userService.modifyUser(user) > 0){
            return true;
        }
        return false;
    }
}
