package com.bigliang.e_commerce.schedule;

import com.bigliang.e_commerce.cache.ActivityCache;
import com.bigliang.e_commerce.cache.LotteryCache;
import com.bigliang.e_commerce.cache.PrizePoolCache;
import com.bigliang.e_commerce.entity.*;
import com.bigliang.e_commerce.po.ActandPrize;
import com.bigliang.e_commerce.protocol.ActivityType;
import com.bigliang.e_commerce.service.ActivityService;
import com.bigliang.e_commerce.service.PrizeService;
import com.bigliang.e_commerce.utils.LotteryUtil;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/10/3 15:25
 */

@Component
public class TimeTask {
    private static final Logger logger = LoggerFactory.getLogger(TimeTask.class);
    private static final double ALLWEIGHT = 1.00;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private PrizeService prizeService;


    /**
     * 定时任务：
     * 每天十二点开始当天的活动，
     * 将当天的活动添加到缓存中
     */
//    @Scheduled(cron = "00 00 12 * * ?")
    @Scheduled(cron = "00 1/3 * * * ?")
    public void addStartActToCache() {
        List<Activity> acts = activityService.getStartActivity();
        acts.forEach(act -> {
            if (act.getActType() == ActivityType.TIMING) {
                ActivityCache.addActivity(act.getActID(), act);
            } else {
                ActandPrize actandPrize = activityService.selectByActID(act.getActID());
                double allweight = 0;
                List<Prize> prizes = actandPrize.getPrizeList();
                for (Prize prize : prizes) {
                    allweight += prize.getPrizeWeight();
                }
                if (allweight < ALLWEIGHT) {
                    Prize prize = new Prize();
                    prize.setPrizeWeight(1.00 - allweight);
                    prize.setPrizeLevel(4);
                    prizes.add(prize);
                }
                Lottery lottery = new Lottery();
                LotteryUtil.calAwardProbability(lottery, prizes);
                LotteryCache.addLottery(act.getActID(), lottery);
                PrizePoolCache.addPrizes(act.getActID(), prizes);
                ActivityCache.addActivity(act.getActID(), act);
            }
        });
        if (acts.size() > 0) {
            activityService.startActivity();
        }
    }

    /**
     * 定时任务：
     * 每天凌晨十二点将所有到结束点的活动停止掉
     */
    @Scheduled(cron = "00 00 00 * * ?")
    public void removeEndActFromCache() {
        List<String> stopActivity = activityService.getStopActivity();
        stopActivity.forEach(actID -> {
            cleanCache(actID);
        });
        activityService.stopActivity();
    }

    private void cleanCache(String actID) {
        Activity act = ActivityCache.removeActivity(actID);
        if (act != null && act.getActType() == ActivityType.TIMING) {
            List<Prize> prizes = prizeService.getAllPrizes(act.getActID());
            List<WaitActivity> allWait = activityService.getAllWait(act.getActID());
            Set<Activitylog> activitylogs = LotteryUtil.timingLottery(allWait, prizes);
            activityService.writeTimingLog(activitylogs);
        } else {
            LotteryCache.removeLottery(actID);
            PrizePoolCache.removePrizes(actID);
        }
    }
}
