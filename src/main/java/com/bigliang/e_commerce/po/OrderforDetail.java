package com.bigliang.e_commerce.po;

import com.bigliang.e_commerce.entity.Goods;
import com.bigliang.e_commerce.entity.Order;

import java.util.List;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/10/11 22:39
 */

public class OrderforDetail {
    private Order order;
    private List<Goods> goodsList;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}
