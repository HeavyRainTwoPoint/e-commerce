package com.bigliang.e_commerce.controller;

import com.bigliang.e_commerce.entity.Order;
import com.bigliang.e_commerce.po.BackTo;
import com.bigliang.e_commerce.po.OrderforDetail;
import com.bigliang.e_commerce.po.PageBean;
import com.bigliang.e_commerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/10/13 19:32
 */

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/getAll")
    public PageBean<Order> getAll(@RequestBody Map<String, Integer> map) {
        return orderService.getAll(map.get("targetPage"));
    }

    @PostMapping("/addOrder")
    public BackTo addOrder(@RequestBody Map<String, String> map){
        int result =  orderService.addOrder(map);
        if (result == 1){
            return new BackTo(true, "购买成功！", 200);
        } else {
            return new BackTo(false, "本次购买失败！", 200);
        }
    }

    @PostMapping("/updateStatus")
    public BackTo updateStatus(@RequestBody Map<String, String> map) {
        int result = orderService.updateOrderStatus(map);
        if (result == 1) {
            return new BackTo(true, "订单状态已修改！", 200);
        } else {
            return new BackTo(false, "更新订单状态失败！", 200);
        }
    }

    @PostMapping("/search")
    public PageBean<Order> search(@RequestBody Map<String, Object> map) {
        return orderService.searchByLimit(map);
    }

    @PostMapping("/getDetail")
    public OrderforDetail getDetail(@RequestBody Map<String, String> map) {
        return orderService.getDetail(map.get("orderID"));
    }



}
