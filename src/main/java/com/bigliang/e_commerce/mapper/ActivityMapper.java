package com.bigliang.e_commerce.mapper;

import com.bigliang.e_commerce.entity.Activity;
import com.bigliang.e_commerce.entity.Activitylog;
import com.bigliang.e_commerce.entity.WaitActivity;
import com.bigliang.e_commerce.po.ActandPrize;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ActivityMapper {
    /**
     * 添加一个活动
     * @param activity 新活动必须的数据封装在一起
     * @return
     */
    int addActivity(Activity activity);

    /**
     * 删除一个活动
     * @param map 提供一个actID
     * @return
     */
    int delActivity(Map<String, String> map);

    /**
     * 获取所有活动
     * @return
     */
    List<Activity> getAllActivity();

    /**
     * 按条件查询所有活动
     * @param activity 可作为查询的参数：
     *                 actID
     *                 actName
     *                 actStatus
     *                 endTIme
     * @return
     */
    List<Activity> searchOnLimited(Activity activity);
//    List<Activity> searchOnLimited(Map<String, String> map);

    /**
     * 查看活动详情
     * @param actID 提供一个actID
     * @return
     */
    ActandPrize selectByActID(String actID);

    /**
     * 获取已经开始的活动
     * @return
     */
    List<Activity> getStartActivity();

    /**
     * 修改到时间开启的活动的状态参数
     * @return
     */
    int startActivity();

    /**
     * 将到截止时间的活动停止掉
     * @return
     */
    int stopActivity();

    /**
     * 获取停止的活动的actID
     * @return
     */
    List<String> getStopActivity();

    /**
     * 写入定时活动参与表中，等待开奖
     * @param waitActivity
     * @return
     */
    int joinTimingLottery(WaitActivity waitActivity);

    /**
     * 获取某个定时活动的所有参与着
     * @param actID
     * @return
     */
    List<WaitActivity> getAllWait(String actID);

    /**
     * 写参与定时抽奖的中奖日志
     * @param set
     * @return
     */
    int writeTimingLog(Set<Activitylog> set);

    /**
     * 写参与即时抽奖的参与/中奖日志日志
     * @param activitylog
     * @return
     */
    int writeSpikeLog(Activitylog activitylog);

    /**
     * 删除活动
     * @param actID
     * @return
     */
    int delActByID(String actID);

    int isJoined(String userID);
}
