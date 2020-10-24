package com.bigliang.e_commerce.mapper;

import com.bigliang.e_commerce.entity.Brand;
import com.bigliang.e_commerce.po.BrandandGoods;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    /**
     * 获取所有的品牌信息
     * @return
     */
    public List<Brand> getAllBrand();
    /**
     * 添加品牌
     * @param brand
     * @return
     */
    public int addBrand(Brand brand);

    /**
     * 删除品牌
     * @param brandName
     * @return
     */
    public int delBrand(String brandName);

    /**
     * 更新品牌信息
     * @param map 提供oldName， newName
     * @return
     */
    public int updateBrand(Map<String, String> map);

    /**
     * 根据品牌获取商品
     * @param brandName
     * @return
     */
    public BrandandGoods getGoodsByBrand(String brandName);
}
