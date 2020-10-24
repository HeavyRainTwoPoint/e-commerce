package com.bigliang.e_commerce.service;

import com.bigliang.e_commerce.entity.Activity;
import com.bigliang.e_commerce.entity.Activitylog;
import com.bigliang.e_commerce.entity.WaitActivity;
import com.bigliang.e_commerce.po.ActandPrize;
import com.bigliang.e_commerce.po.LotteryResult;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ActivityService {
    /**
     * 添加新的活动
     * @param actandPrize 活动和他的奖品们
     * @return
     */
    boolean addNewActivity(ActandPrize actandPrize);

    /**
     * 删除一个活动
     * @param map
     * @return
     */
    int delActivity(Map<String, String> map);

    /**
     * 获取所有活动
     * @return
     */
    List<Activity> getAllActivity();

    /**
     * 按条件查找活动
     * @param activity
     * @return
     */
    List<Activity> searchOnLimited(Activity activity);
//    List<Activity> searchOnLimited(Map<String, String> map);

    /**
     * 查看活动详情
     * @param actID
     * @return
     */
    ActandPrize selectByActID(String actID);

    /**
     * 获取开始的活动
     * @return
     */
    List<Activity> getStartActivity();

    /**
     * 修改已经开始的活动的参数
     * @return
     */
    int startActivity();

    /**
     * 停止到截止时间的活动
     * @return
     */
    int stopActivity();

    /**
     * 获取停止的活动的ID
     * @return
     */
    List<String> getStopActivity();

    /**
     * 参加活动
     * @param waitActivity actID，userID，
     * @return
     */
    int joinTimingLottery(WaitActivity waitActivity);

    /**
     * 获取参与某个定时活动的参与者
     * @param actID
     * @return
     */
    List<WaitActivity> getAllWait(String actID);

    /**
     * 写定时抽奖的日志
     * @param set
     * @return
     */
    int writeTimingLog(Set<Activitylog> set);

    /**
     * 写即时抽奖的日志
     * @param activitylog
     * @return
     */
    int writeSpikeLog(Activitylog activitylog);

    /**
     * 抽奖
     * @param map actID， userID， identity
     * @return
     */
    LotteryResult lottery(Map<String, String> map);
}
