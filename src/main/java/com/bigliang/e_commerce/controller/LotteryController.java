package com.bigliang.e_commerce.controller;

import com.bigliang.e_commerce.cache.LotteryCache;
import com.bigliang.e_commerce.cache.PrizePoolCache;
import com.bigliang.e_commerce.entity.Activity;
import com.bigliang.e_commerce.entity.Lottery;
import com.bigliang.e_commerce.entity.Prize;
import com.bigliang.e_commerce.po.LotteryResult;
import com.bigliang.e_commerce.service.ActivityService;
import com.bigliang.e_commerce.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/10/4 10:24
 */

@RestController
public class LotteryController {
    @Autowired
    private ActivityService activityService;

    @Autowired
    LotteryService lotteryService;

    @PostMapping("/lottery")
    public LotteryResult lottery(@RequestBody Map<String, String> map) {
        return activityService.lottery(map);
    }

    @GetMapping("/lc")
    public ConcurrentHashMap<String, Lottery> lc() {
        return LotteryCache.getLotteryCache();
    }

    @GetMapping("/ll")
    public ConcurrentHashMap<String, List<Prize>> ll() {
        return PrizePoolCache.getPrizePool();
    }

    @PostMapping("/timing")
    public List<Activity> timing() {
        return lotteryService.getTimingAct();
    }

    @PostMapping("/spiking")
    public List<Activity> spiking() {
        return lotteryService.getSpikeAct();
    }
}
