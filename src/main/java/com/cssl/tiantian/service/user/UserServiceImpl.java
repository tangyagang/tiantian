package com.cssl.tiantian.service.user;

import com.cssl.tiantian.dao.user.UserMapper;
import com.cssl.tiantian.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return userMapper.saveUser(user);
    }

    @Override
    public int modifyUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUserByUserId(int userId) {
        return userMapper.deleteUserByUserId(userId);
    }
}
