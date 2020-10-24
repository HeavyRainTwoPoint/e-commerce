package com.bigliang.e_commerce.service.impl;

import com.bigliang.e_commerce.cache.ActivityCache;
import com.bigliang.e_commerce.entity.Activity;
import com.bigliang.e_commerce.entity.Lottery;
import com.bigliang.e_commerce.mapper.LotteryMapper;
import com.bigliang.e_commerce.protocol.ActivityType;
import com.bigliang.e_commerce.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/10/3 22:58
 */

@Service
public class LotteryServiceImpl implements LotteryService {
    @Autowired
    private LotteryMapper lotteryMapper;
    @Override
    public Lottery getLotteryByActID(String actID) {
        return lotteryMapper.getLotteryByActID(actID);
    }

    @Override
    public int addLottery(Lottery lottery) {
        return lotteryMapper.addLottery(lottery);
    }

    @Override
    public int delLottery(String actID) {
        return lotteryMapper.delLottery(actID);
    }

    @Override
    public List<Activity> getTimingAct() {
        return getActByType(ActivityType.TIMING);
    }

    @Override
    public List<Activity> getSpikeAct() {
        return getActByType(ActivityType.SPIKE);
    }

    /**
     * 遍历缓存获取已经开始的活动
     * @param actType  根据需要获取不同类型的活动
     * @return
     */
    public List<Activity> getActByType(int actType) {
        List<Activity> list = new ArrayList<>();
        ActivityCache.getCache().forEach((aID, activity) -> {
            if (activity.getActType() == actType) {
                list.add(activity);
            }
        });
        return list;
    }
}
