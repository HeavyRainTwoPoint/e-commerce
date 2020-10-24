package com.bigliang.e_commerce.controller;

import com.bigliang.e_commerce.entity.Admin;
import com.bigliang.e_commerce.po.BackTo;
import com.bigliang.e_commerce.service.AdminService;
import com.bigliang.e_commerce.utils.IDGenerator;
import com.bigliang.e_commerce.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/9/12 15:08
 */

@Controller
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    @ResponseBody
    public BackTo login(@RequestBody Admin admin) {
        int result = adminService.check(admin);
        BackTo backTo = new BackTo();
        if (result == 1) {
            backTo.setResult(true);
            backTo.setCode(200);
            String token = TokenUtil.token();
            backTo.setToken(token);
            backTo.setMessage("登录成功！");
        } else {
            backTo.setMessage("用户名或密码错误！");
            backTo.setCode(200);
            backTo.setResult(false);
        }
        return backTo;
    }
}
