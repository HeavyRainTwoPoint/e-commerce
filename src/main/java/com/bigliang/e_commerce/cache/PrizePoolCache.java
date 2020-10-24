package com.bigliang.e_commerce.cache;

import com.bigliang.e_commerce.entity.Prize;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/10/3 22:35
 */

public final class PrizePoolCache {
    private static final ConcurrentHashMap<String, List<Prize>> prizePool = new ConcurrentHashMap<>();

    public static List<Prize> getPrizes(String actID) {
        return prizePool.get(actID);
    }

    public static void addPrizes(String actID, List<Prize> prizes) {
        prizePool.put(actID, prizes);
    }

    public static void removePrizes(String actID) {
        prizePool.remove(actID);
    }

    public static ConcurrentHashMap<String, List<Prize>> getPrizePool() {
        return prizePool;
    }
}
