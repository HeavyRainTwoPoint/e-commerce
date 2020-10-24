package com.bigliang.e_commerce.po;

import com.bigliang.e_commerce.entity.Brand;
import com.bigliang.e_commerce.entity.Goods;

import java.util.List;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/10/5 22:13
 */

public class BrandandGoods {
    private Brand brand;
    private List<Goods> goodsList;

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}
