package com.cssl.tiantian.dao.user;

import com.cssl.tiantian.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    //判断用户名是否存在
    public User getUserByUserName(String userName);
    //登录
    public User getUserByUserNameAndPassword(@Param("userName") String userName,@Param("password") String password);
    //注册
    public int saveUser(User user);
    //修改用户
    public int updateUser(User user);
    //删除用户
    public int deleteUserByUserId(int userId);
    //根据用户ID查询一个用户
    public User getUserByUserId(@Param("userId") int userId);
}
