package com.bigliang.e_commerce.service.impl;

import com.bigliang.e_commerce.entity.Admin;
import com.bigliang.e_commerce.mapper.AdminMapper;
import com.bigliang.e_commerce.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/9/25 10:17
 */

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper  adminMapper;

    @Override
    public int check(Admin admin) {
        return adminMapper.check(admin);
    }
}
