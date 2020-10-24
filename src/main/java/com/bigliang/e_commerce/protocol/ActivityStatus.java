package com.bigliang.e_commerce.protocol;

/**
 * 活动状态标识
 */
public interface ActivityStatus {
    /**
     * 等待开始
     */
    int WAITFORSTART = 3;
    /**
     * 持续中
     */
    int STARTING = 2;
    /**
     * 已结束
     */
    int ENDED = 1;

}
