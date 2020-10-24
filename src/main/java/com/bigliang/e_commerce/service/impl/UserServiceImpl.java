package com.bigliang.e_commerce.service.impl;

import com.bigliang.e_commerce.entity.User;
import com.bigliang.e_commerce.mapper.UserMapper;
import com.bigliang.e_commerce.service.UserService;
import com.bigliang.e_commerce.utils.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/10/2 10:16
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int checkLogin(Map<String, String> map) {
        int result = userMapper.checkLogin(map);
        if (result == 1) {
            updateLoginCount(map.get("userID"));
        }
        return result;
    }

    @Override
    public int addUsers(List<User> list) {
        list.forEach(u -> {
            u.setUserID(IDGenerator.getUserID());
            u.setImagePath("默认头像.jpg");
        });
        return userMapper.addUsers(list);
    }

    @Override
    public int addUser(User user) {
        String userID = IDGenerator.getUserID();
        user.setUserID(userID);
        user.setImagePath("默认头像.jpg");
        return userMapper.addUser(user);
    }

    @Override
    public User getUserByID(String userID) {
        return userMapper.getUserByID(userID);
    }

    @Override
    public int updateLoginCount(String userID) {
        return userMapper.updateLoginCount(userID);
    }

    @Override
    public int updateUserImage(Map<String, String> map) {
        return userMapper.updateUserImage(map);
    }
}
