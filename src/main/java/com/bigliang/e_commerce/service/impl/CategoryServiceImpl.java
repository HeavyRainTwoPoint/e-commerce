package com.bigliang.e_commerce.service.impl;

import com.bigliang.e_commerce.entity.Category;
import com.bigliang.e_commerce.mapper.CategoryMapper;
import com.bigliang.e_commerce.po.CategoryandGoods;
import com.bigliang.e_commerce.service.CategoryService;
import com.bigliang.e_commerce.utils.IDGenerator;
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
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getAllCategory() {
        return categoryMapper.getAllCategory();
    }

    @Override
    public int addCategory(Category category) {
        category.setCategoryID(IDGenerator.getCategoryID());
        return categoryMapper.addCategory(category);
    }

    @Override
    public int delCategory(String categoryID) {
        return categoryMapper.delCategory(categoryID);
    }

    @Override
    public int updateCategory(Map<String, String> map) {
        return categoryMapper.updateCategory(map);
    }

    @Override
    public CategoryandGoods getGoodsByCategory(String cateGoryID) {
        return categoryMapper.getGoodsByCategory(cateGoryID);
    }
}
