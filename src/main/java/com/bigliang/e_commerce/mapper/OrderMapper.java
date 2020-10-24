package com.bigliang.e_commerce.mapper;

import com.bigliang.e_commerce.entity.Order;
import com.bigliang.e_commerce.entity.OrderDetails;
import com.bigliang.e_commerce.po.OrderforDetail;
import com.bigliang.e_commerce.po.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @author 小胖五
 */
public interface OrderMapper {
    /**
     * 分页获取订单信息
     * @return
     */
    List<Order> getAll(PageBean<Order> pageBean);

    /**
     * 分页总数
     */
    int totalCount();

    /**
     * 生成一个订单
     * @param order
     * @return
     */
    int addOrder(Order order);

    /**
     * 添加订单细节信息
     * @param orderDetails
     * @return
     */
    int addOrderDetail(OrderDetails orderDetails);

    /**
     * 修改订单的状态
     * @param map 提供orderID, orderStatus
     * @return
     */
    int updateOrderStatus(Map<String, String> map);

    /**
     * 删除订单
     * @param orderID
     * @return
     */
    int delOrder(String orderID);

    /**
     * 删除订单详情
     * @param orderID
     * @return
     */
    int delOrderDetail(String orderID);


    /**
     * 按条件查询订单信息
     * @param map 封装着一个order对象包含需要筛选的条件，pageBean
     * @return
     */
    List<Order> searchByLimit(Map<String, Object> map);

    /**
     * 分页获取通过条件查询到的订单
     * @return
     */
    int getSearchTotalCount(Map<String, Object> map);

    /**
     *
     * @param orderID
     * @return
     */
    OrderforDetail getDetail(String orderID);

}
