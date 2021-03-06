package com.cssl.tiantian.service.user;

import com.cssl.tiantian.dao.user.UserMapper;
import com.cssl.tiantian.pojo.User;
import com.cssl.tiantian.tools.PojoTransformationMap;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public PageInfo<User> findUserByUserIdAndUserType(int pageNo, int pageSize, int userId, int userType) {
        PageHelper.startPage(pageNo,pageSize);
        List<User> list = userMapper.getUserByUserIdAndUserType(userId,userType);
        return new PageInfo<User>(list);
    }

}
