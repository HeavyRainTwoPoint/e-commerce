package com.bigliang.e_commerce.service.impl;

import com.bigliang.e_commerce.cache.ActivityCache;
import com.bigliang.e_commerce.cache.LotteryCache;
import com.bigliang.e_commerce.cache.PrizePoolCache;
import com.bigliang.e_commerce.entity.*;
import com.bigliang.e_commerce.mapper.ActivityMapper;
import com.bigliang.e_commerce.mapper.LotteryMapper;
import com.bigliang.e_commerce.mapper.PrizeMapper;
import com.bigliang.e_commerce.po.ActandPrize;
import com.bigliang.e_commerce.po.LotteryResult;
import com.bigliang.e_commerce.protocol.ActivityType;
import com.bigliang.e_commerce.service.ActivityService;
import com.bigliang.e_commerce.utils.IDGenerator;
import com.bigliang.e_commerce.utils.LotteryUtil;
import com.bigliang.e_commerce.utils.TimeUtil;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/9/22 0:24
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private PrizeMapper prizeMapper;

    @Autowired
    private LotteryMapper lotteryMapper;

    private static final double ALLWEIGHT = 1.00D;

    /**
     * 获取到活动和相应的奖品之后就会根据活动类型对查看是否需要对奖品进行加工
     * @param actandPrize
     * @return
     */
    @Override
    public boolean addNewActivity(ActandPrize actandPrize) {
//        boolean value = false;
        String aID = "";
        try {
            Activity activity = actandPrize.getActivity();
            String actID = IDGenerator.getActivityID();
            aID = actID;
            activity.setActID(actID);
            actandPrize.getPrizeList().forEach(prize -> {
                prize.setReferenceTo(actID);
                prize.setPrizeId(IDGenerator.getPrizeID());
                if (activity.getActType() == ActivityType.SPIKE) {
                    prize.setPrizeWeight(0.20D);
                }
            });
            if (activity.getActType() == (ActivityType.SPIKE)) {
                Lottery lottery = new Lottery();
                LotteryUtil.calAwardProbability(lottery, actandPrize.getPrizeList());
                lottery.setActID(actID);
                activityMapper.addActivity(activity);
                prizeMapper.addPrizes(actandPrize.getPrizeList());
            } else {
                activityMapper.addActivity(activity);
                prizeMapper.addPrizes(actandPrize.getPrizeList());
            }
            if (TimeUtil.isNow(activity.getStartTime())) {
                activityMapper.startActivity();
                if (activity.getActType() == ActivityType.TIMING) {
                    ActivityCache.addActivity(activity.getActID(), activity);
                } else {
                    double allweight = 0;
                    List<Prize> prizes = actandPrize.getPrizeList();
                    for (Prize prize : prizes) {
                        allweight += prize.getPrizeWeight();
                    }
                    if (allweight < ALLWEIGHT) {
                        Prize prize = new Prize();
                        prize.setPrizeWeight(ALLWEIGHT - allweight);
                        prize.setPrizeLevel(4);
                        prizes.add(prize);
                    }
                    Lottery lottery = new Lottery();
                    LotteryUtil.calAwardProbability(lottery, prizes);
                    LotteryCache.addLottery(activity.getActID(), lottery);
                    PrizePoolCache.addPrizes(activity.getActID(), prizes);
                    ActivityCache.addActivity(activity.getActID(), activity);
                }
            }
            return true;

        } catch (Exception e) {
            String messgae = "创建活动异常：" + e.getMessage();
            LoggerFactory.getLogger(this.getClass()).error(()-> {
                return messgae;
            });
            activityMapper.delActByID(aID);
            return false;
        }
    }

    @Override
    public int delActivity(Map<String, String> map) {
        try {
            activityMapper.delActivity(map);
            prizeMapper.delPrize(map);
            lotteryMapper.delLottery(map.get("actID"));
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error(() -> e.getMessage());
            return -1;
        }
        return 1;
    }

    @Override
    public List<Activity> getAllActivity() {
        return activityMapper.getAllActivity();
    }

    @Override
    public List<Activity> searchOnLimited(Activity activity) {
        return activityMapper.searchOnLimited(activity);
    }


    @Override
    public ActandPrize selectByActID(String actID) {
        return activityMapper.selectByActID(actID);
    }

    /**
     * 获取最新开启的活动
     * @return
     */
    @Override
    public List<Activity> getStartActivity() {
        return activityMapper.getStartActivity();
    }

    /**
     * 将这些到点开启的活动的状态修改为已开启
     * @return
     */
    @Override
    public int startActivity() {
        return activityMapper.startActivity();
    }

    /**
     * 将需要停止的活动的状态修改为结束
     * @return
     */
    @Override
    public int stopActivity() {
        return activityMapper.stopActivity();
    }

    /**
     * 获取已经停止的活动活动ID
     * @return
     */
    @Override
    public List<String> getStopActivity() {
        return activityMapper.getStopActivity();
    }

    /**
     * 将参与本次活动的用户记录在数据库中
     * @param waitActivity
     * @return
     */
    @Override
    public int joinTimingLottery(WaitActivity waitActivity) {
        if (activityMapper.isJoined(waitActivity.getUserId()) > 0) {
            return 0;
        }
        return activityMapper.joinTimingLottery(waitActivity);
    }

    /**
     * 获取参与本次抽奖活动的用户
     * @param actID
     * @return
     */
    @Override
    public List<WaitActivity> getAllWait(String actID) {
        return activityMapper.getAllWait(actID);
    }

    /**
     * 将中奖的用户写入中奖日志中
     * @param set
     * @return
     */
    @Override
    public int writeTimingLog(Set<Activitylog> set) {
        return activityMapper.writeTimingLog(set);
    }

    /**
     * 将本次中奖的用户记录在中奖日志中
     * @param activitylog
     * @return
     */
    @Override
    public int writeSpikeLog(Activitylog activitylog) {
        return activityMapper.writeSpikeLog(activitylog);
    }

    /**
     * 即时抽奖
     * @param map identity、actID、userID
     * @return
     */
    @Override
    public LotteryResult lottery(Map<String, String> map) {
        int userIdentity = Integer.parseInt(map.get("identity"));
        System.out.println("identity:" + userIdentity);
        Activity activity = ActivityCache.getActivity(map.get("actID"));
        if (activity == null) {
            return new LotteryResult(false, "活动暂时还没开始！请耐心等待！", 4002);
        }
        if (userIdentity >= activity.getLimited()) {
            if (activity.getActType() == ActivityType.SPIKE) {
                Lottery lottery = LotteryCache.getLottery(activity.getActID());
                Prize prize = LotteryUtil.spikeLottery(lottery, PrizePoolCache.getPrizes(activity.getActID()));
                int level = prize.getPrizeLevel();
                if (level <= 3) {
                    Map<String, String> hashMap = new HashMap<>();
                    hashMap.put("actID", activity.getActID());
                    hashMap.put("prizeID", prize.getPrizeId());
                    int result = prizeMapper.cutPrize(hashMap);
                    if (result == 1) {
                        activityMapper.writeSpikeLog(new Activitylog(map.get("userID"), activity.getActID(), prize.getPrizeId()));
                        return new LotteryResult(true, "恭喜中奖！", 2000 + prize.getPrizeLevel());
                    } else {
                        activityMapper.writeSpikeLog(new Activitylog(map.get("userID"), activity.getActID(), null));
                        return new LotteryResult(false, "谢谢参与！", 2004);
                    }
                } else {
                    activityMapper.writeSpikeLog(new Activitylog(map.get("userID"), activity.getActID(), null));
                    return new LotteryResult(false, "谢谢参与！", 2004);
                }
            } else {
                int result = joinTimingLottery(new WaitActivity(map.get("userID"), activity.getActID()));
                return result == 1 ? new LotteryResult(true, "参与成功！待活动结束后可以查看中奖结果！", 2005)
                        : new LotteryResult(false, "您已经参加过本次活动了哦~", 4004);
            }
        } else {
            return new LotteryResult(false, "抱歉！您无法参与本次该活动！", 4001);
        }
    }
}
