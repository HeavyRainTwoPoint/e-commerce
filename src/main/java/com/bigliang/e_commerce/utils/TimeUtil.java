package com.bigliang.e_commerce.utils;

import sun.util.resources.cldr.af.CalendarData_af_NA;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/10/23 21:38
 */

public class TimeUtil {
    /**
     * 时间判断工具，判断给定时间与当前时间的日是否一致
     * @param startTime
     * @return
     */
    public static boolean isNow(Timestamp startTime) {
        SimpleDateFormat judgeTime = new SimpleDateFormat("yy-MM-dd");
        SimpleDateFormat currentTime = new SimpleDateFormat("yy-MM-dd");
        String judgeTimeStr = judgeTime.format(startTime);
        String currentTimeStr = currentTime.format(System.currentTimeMillis());
        return judgeTimeStr.equals(currentTimeStr) ? true : false;
    }
}
