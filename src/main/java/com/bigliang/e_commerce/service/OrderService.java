package com.bigliang.e_commerce.service;

import com.bigliang.e_commerce.entity.Order;
import com.bigliang.e_commerce.po.OrderforDetail;
import com.bigliang.e_commerce.po.PageBean;

import java.util.Map;

/**
 * @author 大雨两点
 */
public interface OrderService {
    /**
     * 分页获取订单信息
     * @return
     */
    PageBean<Order> getAll(int targetPage);


    /**
     * 添加订单
     * @param map 提供userID， goodsID， count
     * @return
     */
    int addOrder(Map<String, String> map);

    /**
     * 修改订单的状态
     * @param map 提供orderID, orderStatus
     * @return
     */
    int updateOrderStatus(Map<String, String> map);


    /**
     * 按条件查询订单信息
     * @param map 提供orderID，orderStatus, userID, createTime, targetPage, limit
     * @return
     */
    PageBean<Order> searchByLimit(Map<String, Object> map);

    /**
     * 获取订单细节
     * @param orderID
     * @return
     */
    OrderforDetail getDetail(String orderID);
}
