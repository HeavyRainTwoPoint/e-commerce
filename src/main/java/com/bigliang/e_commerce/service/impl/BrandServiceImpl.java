package com.bigliang.e_commerce.service.impl;

import com.bigliang.e_commerce.entity.Brand;
import com.bigliang.e_commerce.mapper.BrandMapper;
import com.bigliang.e_commerce.po.BrandandGoods;
import com.bigliang.e_commerce.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/10/8 17:08
 */

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> getAllBrand() {
        return brandMapper.getAllBrand();
    }

    @Override
    public int addBrand(Brand brand) {
        return brandMapper.addBrand(brand);
    }

    @Override
    public int delBrand(String brandName) {
        return brandMapper.delBrand(brandName);
    }

    @Override
    public int updateBrand(Map<String, String> map) {
        return brandMapper.updateBrand(map);
    }

    @Override
    public BrandandGoods getGoodsByBrand(String brandName) {
        return brandMapper.getGoodsByBrand(brandName);
    }
}
