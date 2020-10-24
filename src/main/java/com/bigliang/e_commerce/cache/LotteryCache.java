package com.bigliang.e_commerce.cache;

import com.bigliang.e_commerce.entity.Lottery;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/10/3 21:26
 */

public final class LotteryCache {
    private static final ConcurrentHashMap<String, Lottery> lotteryCache = new ConcurrentHashMap<>();

    /**
     * 添加秒杀活动设置
     * @param actID
     * @param lottery
     */
    public static void addLottery(String actID, Lottery lottery) {
        lotteryCache.put(actID, lottery);
    }

    /**
     * 移除某个活动的属性设置
     * @param actID
     */
    public static void removeLottery(String actID) {
        lotteryCache.remove(actID);
    }

    /**
     * 获取某个活动的属性设置
     * @param actID
     * @return
     */
    public static Lottery getLottery(String actID) {
        return lotteryCache.get(actID);
    }

    public static ConcurrentHashMap<String, Lottery> getLotteryCache() {
        return lotteryCache;
    }
}
