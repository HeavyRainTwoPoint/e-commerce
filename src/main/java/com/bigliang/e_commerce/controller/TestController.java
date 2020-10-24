package com.bigliang.e_commerce.controller;

import com.bigliang.e_commerce.entity.Goods;
import com.bigliang.e_commerce.entity.Order;
import com.bigliang.e_commerce.entity.User;
import com.bigliang.e_commerce.po.ActandPrize;
import com.bigliang.e_commerce.utils.TimeUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Map;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/9/22 0:06
 */

@RestController
public class TestController {
    @RequestMapping("/test")
    public ActandPrize test(@RequestBody ActandPrize actandPrize) {
        return actandPrize;
    }

    @RequestMapping("/testUser")
    public User test(@RequestBody User user) {
        return user;
    }

    @RequestMapping("/goods")
    public Goods goods(){
        return new Goods();
    }

    @RequestMapping("/limit")
    public Map<String, String> limit(@RequestBody Map<String, String> map) {
        System.out.println(map.get("orderStatus"));
        return map;
    }

    @RequestMapping("/order")
    public Order order(){
        return new Order();
    }

    @RequestMapping("/time")
    public boolean isNow(@RequestBody Map<String, Timestamp> map) {
        return TimeUtil.isNow(map.get("timestamp"));
    }
}
