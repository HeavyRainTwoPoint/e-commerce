package com.bigliang.e_commerce.service;

import com.bigliang.e_commerce.entity.Category;
import com.bigliang.e_commerce.po.CategoryandGoods;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    /**
     * 获取所有的类别信息
     * @return
     */
    public List<Category> getAllCategory();

    /**
     * 添加分类
     * @param category
     * @return
     */
    public int addCategory(Category category);

    /**
     * 删除分类
     * @param categoryID
     * @return
     */
    public int delCategory(String categoryID);

    /**
     * 修改分类信息
     * @param map
     * @return
     */
    public int updateCategory(Map<String, String> map);

    /**
     * 根据类别获取货物
     * @param categoryID
     * @return
     */
    public CategoryandGoods getGoodsByCategory(String categoryID);
}
