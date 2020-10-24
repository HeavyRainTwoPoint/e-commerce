package com.bigliang.e_commerce.service.impl;

import com.bigliang.e_commerce.entity.Admin;
import com.bigliang.e_commerce.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/9/12 17:14
 */
@Service
public class LoginServiceImpl {
    @Autowired
    private LoginMapper loginMapper;

    public Admin getAdmin(Admin admin) {
        return loginMapper.getAdmin(admin);
    }
}
