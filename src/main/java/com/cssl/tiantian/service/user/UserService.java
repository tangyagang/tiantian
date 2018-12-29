package com.cssl.tiantian.service.user;

import com.cssl.tiantian.pojo.User;

public interface UserService {

    //判断用户名是否存在
    public User isExistUserName(String userName);
    //登录
    public User loginUser(String userName,String password);
    //注册
    public int registerUser(User user);
    //修改用户
    public int modifyUser(User user);
    //删除用户
    public int deleteUserByUserId(int userId);
}
