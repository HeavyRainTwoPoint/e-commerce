package com.bigliang.e_commerce.mapper;

import com.bigliang.e_commerce.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 登录校验
     * @param map 提供loginAccount、password
     * @return
     */
    public int checkLogin(Map<String, String> map);

    /**
     * 批量插入
     * @param list
     * @return
     */
    public int addUsers(List<User> list);

    /**
     * 插入一个用户
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * 根据ID获取用户
     * @param userID
     * @return
     */
    public User getUserByID(String userID);

    /**
     * 根据用户ID修改用户登录次数
     * @param userID
     * @return
     */
    public int updateLoginCount(String userID);

    /**
     * 修改用户头像
     * @param map 提供imagePath、userID
     * @return
     */
    public int updateUserImage(Map<String, String> map);
}
