package com.bigliang.e_commerce.protocol;

/**
 * 活动类型标识
 */
public interface ActivityType {
    /**
     * @param SPIKE 秒杀类型抽奖
     */
    int SPIKE = 1;

    /**
     * @param TIMING 定时类型抽奖
     */
    int TIMING = 2;
}
