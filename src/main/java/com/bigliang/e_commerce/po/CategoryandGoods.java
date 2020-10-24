package com.bigliang.e_commerce.po;

import com.bigliang.e_commerce.entity.Category;
import com.bigliang.e_commerce.entity.Goods;

import java.util.List;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/10/5 22:16
 */

public class CategoryandGoods {
    private Category category;
    private List<Goods> goodsList;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}
