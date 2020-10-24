package com.bigliang.e_commerce.controller;

import com.bigliang.e_commerce.entity.User;
import com.bigliang.e_commerce.po.BackTo;
import com.bigliang.e_commerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/10/2 10:24
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public BackTo login(@RequestBody Map<String, String> map) {
        int result = userService.checkLogin(map);
        return result == 1 ? new BackTo(true) : new BackTo(false);
    }

    @PostMapping("/register")
    public BackTo register(@RequestBody User user) {
        int result = userService.addUser(user);
        return result == 1 ? new BackTo(true) : new BackTo(false);
    }

    @PostMapping("/batchAdd")
    public BackTo batchAdd(@RequestBody List<User> list) {
        int result = userService.addUsers(list);
        return result > 0 ? new BackTo(true) : new BackTo(false);
    }

    @PostMapping("/updateImg")
    public BackTo updateImg(@RequestBody Map<String, String> map) {
        int result = userService.updateUserImage(map);
        return result == 1 ? new BackTo(true) : new BackTo(false);
    }
}
