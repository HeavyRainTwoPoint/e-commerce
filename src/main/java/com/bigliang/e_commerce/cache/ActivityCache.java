package com.bigliang.e_commerce.cache;

import com.bigliang.e_commerce.entity.Activity;
import com.bigliang.e_commerce.entity.Lottery;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/9/22 12:28
 */

public final class ActivityCache {
    /**
     * 作为已经开始的活动的缓存
     */
    private static final ConcurrentHashMap<String, Activity> activitysCache = new ConcurrentHashMap<>();

    /**
     * 达到开始条件的活动就加在活动缓存中去
     * @param actID
     * @param activity
     */
    public static void addActivity(String actID, Activity activity) {
        activitysCache.put(actID, activity);
    }

    /**
     * 根据活动ID获取相应的活动
     * @param actID
     * @return
     */
    public static Activity getActivity(String actID) {
        return activitysCache.get(actID);
    }

    /**
     * 移除某个活动
     * @param actID
     */
    public static Activity removeActivity(String actID) {
        return activitysCache.remove(actID);
    }

    public static ConcurrentHashMap<String, Activity> getCache() {
        return activitysCache;
    }

}
