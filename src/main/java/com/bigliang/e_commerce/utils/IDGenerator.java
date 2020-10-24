package com.bigliang.e_commerce.utils;

import org.apache.commons.lang.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/9/19 15:44
 */

public final class IDGenerator {
    private final static  String PRIFIX = "GR";

    /**
     * 生成一个用户ID
     * @return
     */
    public static String getUserID() {
        String codeString = RandomStringUtils.randomNumeric(8);
        return PRIFIX + codeString;
    }

    /**
     * 生成一个奖品ID
     * @return
     */
    public static String getPrizeID() {
        return RandomStringUtils.randomNumeric(6);
    }

    /**
     * 生成一个活动ID
     * @return
     */
    public static String getActivityID() {
        return RandomStringUtils.randomAlphanumeric(8);
    }

    /**
     * 返回一个商品ID
     * @return
     */
    public static String getGoodsID() {
        return "G" + RandomStringUtils.randomNumeric(5);
    }

    /**
     * 返回类别ID
     * @return
     */
    public static String getCategoryID() {
        return "C" + RandomStringUtils.randomNumeric(4);
    }

    /**
     * 返回订单ID
     * @return
     */
    public static String getOrderID() {
        long timeMillis = System.currentTimeMillis();
        String orderID = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(timeMillis));
        return orderID;
    }

}
