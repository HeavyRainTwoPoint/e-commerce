package com.bigliang.e_commerce.service.impl;

import com.bigliang.e_commerce.entity.Order;
import com.bigliang.e_commerce.entity.OrderDetails;
import com.bigliang.e_commerce.mapper.OrderMapper;
import com.bigliang.e_commerce.po.OrderforDetail;
import com.bigliang.e_commerce.po.PageBean;
import com.bigliang.e_commerce.protocol.OrderStatus;
import com.bigliang.e_commerce.service.OrderService;
import com.bigliang.e_commerce.utils.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/10/13 10:13
 */

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public PageBean<Order> getAll(int targetPage) {
        PageBean<Order> pageBean = new PageBean<>();
        int totalCount = orderMapper.totalCount();
        int totalPage = 0;
        if (totalCount % pageBean.getLimit() == 0) {
            targetPage = totalCount / pageBean.getLimit();
        } else {
            targetPage = (targetPage /pageBean.getLimit()) + 1;
        }
        pageBean.setTotalPage(totalPage);
        pageBean.setTargetPage((targetPage - 1) * pageBean.getLimit());
        List<Order> orders = orderMapper.getAll(pageBean);
        pageBean.setEntryList(orders);
        return pageBean;
    }

    /**
     * 订单信息：
     *  订单ID：后台生成
     *  订单发起人 前端发送
     *  订单创建时间 自动生成
     *  订单状态 默认值
     * 订单详情
     *  订单ID 复用
     *  货物ID 前端发送
     *  货物数量 前端发送
     * @param map
     * @return
     */
    @Override
    public int addOrder(Map<String, String> map) {
        String orderID = IDGenerator.getOrderID();
        try {
            Order order = new Order(orderID, map.get("userID"), OrderStatus.ORDER_COMFIRMING);
            long count = Long.parseLong(map.get("count"));
            OrderDetails orderDetails = new OrderDetails(orderID, map.get("goodsID"), count);
            int addOrder = orderMapper.addOrder(order);
            int addOrderDetail = orderMapper.addOrderDetail(orderDetails);
            if (addOrder == 1 && addOrderDetail == 1) {
                return addOrder;
            } else {
                if (addOrder == 1) {
                    orderMapper.delOrder(orderID);
                }
                if (addOrderDetail == 1) {
                    orderMapper.delOrderDetail(orderID);
                }
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public int updateOrderStatus(Map<String, String> map) {
        return orderMapper.updateOrderStatus(map);
    }

    /**
     * 按条件查询
     * @param map 数据集
     * @return
     */
    @Override
    public PageBean<Order> searchByLimit(Map<String, Object> map) {
        PageBean<Order> pageBean = new PageBean<>();
        int targetPage = 0;
        try {
            targetPage = (int)map.get("targetPage");
        } catch (Exception e) {
            System.out.println(e);
            return pageBean;
        }
        int totalCount = orderMapper.getSearchTotalCount(map);
        int totalPage = 0;
        if (totalCount % pageBean.getLimit() == 0) {
            totalPage = totalCount / pageBean.getLimit();
        } else {
            totalPage = (totalCount / pageBean.getLimit()) + 1;
        }
        pageBean.setTotalPage(totalPage);
        pageBean.setTotalCount(totalCount);
        pageBean.setTargetPage((targetPage - 1) * pageBean.getLimit());
        map.put("limit", pageBean.getLimit());
        List<Order> orders = orderMapper.searchByLimit(map);
        pageBean.setEntryList(orders);
        return pageBean;
    }

    @Override
    public OrderforDetail getDetail(String orderID) {
        return orderMapper.getDetail(orderID);
    }
}
