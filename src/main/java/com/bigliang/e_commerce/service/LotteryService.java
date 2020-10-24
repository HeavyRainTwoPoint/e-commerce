package com.bigliang.e_commerce.service;

import com.bigliang.e_commerce.entity.Activity;
import com.bigliang.e_commerce.entity.Lottery;
import com.bigliang.e_commerce.po.ActandPrize;

import java.util.List;
import java.util.Map;

public interface LotteryService {
    Lottery getLotteryByActID(String actID);

    int addLottery(Lottery lottery);

    int delLottery(String actID);

    //-----------------------------------------

    /**
     * 获取定时抽奖活动
     * @return
     */
    List<Activity> getTimingAct();

    /**
     * 获取即时抽奖活动
     * @return
     */
    List<Activity> getSpikeAct();

}
