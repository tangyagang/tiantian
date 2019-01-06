package com.cssl.tiantian.service.user;

import com.cssl.tiantian.dao.user.UserMapper;
import com.cssl.tiantian.pojo.User;
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
        return userMapper.saveUser(objectMap(user));
    }
    /**
     * 实体对象转成Map
     * @param obj 实体对象
     * @return
     */
    public static Map<String, Object> objectMap(Object obj) {
        Map<String, Object> map = new HashMap<>();
        if (obj == null) {
            return map;
        }
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if(field.get(obj) == null || field.get(obj).equals("")){
                    continue;
                }
                map.put(field.getName(), field.get(obj));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
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
        return userMapper.getUserByUserId(userId);
    }

}
