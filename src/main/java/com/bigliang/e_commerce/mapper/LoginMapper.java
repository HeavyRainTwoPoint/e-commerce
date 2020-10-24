package com.bigliang.e_commerce.mapper;

import com.bigliang.e_commerce.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/9/12 15:09
 */

public interface LoginMapper {
    public Admin getAdmin(Admin admin);

}
