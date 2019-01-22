package com.cssl.tiantian.service.user;

import com.cssl.tiantian.dao.user.UserMapper;
import com.cssl.tiantian.pojo.User;
import com.cssl.tiantian.tools.PojoTransformationMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User isExistUserName(String userName) {
        return userMapper.getUserByUserName(userName);
    }

    @Override
    public User loginUser(String userName, String password) {
        return userMapper.getUserByUserNameAndPassword(userName,password);
    }

    @Override
    public int registerUser(User user) {
        return userMapper.saveUser(PojoTransformationMap.objectMap(user));
    }

    @Override
    public int modifyUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUserByUserId(int userId) {
        return userMapper.deleteUserByUserId(userId);
    }

    @Override
    public User findUserByUserId(int userId) {
        User user = userMapper.getUserByUserId(userId);
        return user;
    }

    @Override
    public User findUserByPhone(String phone) {
        return userMapper.getUserByPhone(phone);
    }

}
