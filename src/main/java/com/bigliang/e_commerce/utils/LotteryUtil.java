package com.bigliang.e_commerce.utils;

import com.bigliang.e_commerce.entity.Activitylog;
import com.bigliang.e_commerce.entity.Lottery;
import com.bigliang.e_commerce.entity.Prize;
import com.bigliang.e_commerce.entity.WaitActivity;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/9/19 14:36
 */

public class LotteryUtil {
    private static Logger logger = LoggerFactory.getLogger(LotteryUtil.class);
    private static final Random random = new Random();
    private static final Integer MAXSOPE = 100000000;


    /**
     * 获取开奖范围
     *
     * @param lottery   记录本次抽奖信息
     * @param prizeList
     */
    public static void calAwardProbability(Lottery lottery, List<Prize> prizeList) {
        Integer codeScope = 1;
        for (Prize prize : prizeList) {
            Integer nowScope = 1;
            //获取中奖概率
            Double awardProbability = prize.getPrizeWeight();
            while (true) {
                Double test = awardProbability * nowScope;
                // 概率的精确度，调整到小数点后10位，概率太小等于不中奖，跳出
                if (test < 0.0000000001) {
                    break;
                }
                if ((test >= 1L && (test - test.longValue()) < 0.0001D) || nowScope >= MAXSOPE) {
                    if (nowScope > codeScope) {
                        // 设置中奖范围
                        codeScope = nowScope;
                    }
                    break;
                } else {
                    // 中奖数字范围以10倍进行增长
                    nowScope = nowScope * 10;
                }
            }
        }
        Integer winningStartCode = 0;
        Integer winningEndCode = winningStartCode;

        for (Prize prize : prizeList) {
            Integer codeNum = (int) (prize.getPrizeWeight() * codeScope); // 获得其四舍五入的整数值
            // 无人中奖时，将中奖的起始范围设置在随机数的范围之外
            if (codeNum == 0) {
                prize.setStartCode(codeScope + 1);
                prize.setEndCode(codeScope + 1);
            } else {
                prize.setStartCode(winningEndCode);
                prize.setEndCode(winningEndCode + codeNum - 1);
                winningEndCode = winningEndCode + codeNum;
            }
        }
        // 设置用户的中奖随机码信息
        lottery.setWinningStartCode(winningStartCode);
        lottery.setWinningEndCode(winningEndCode);
        lottery.setCodeScope(codeScope);
    }

    /**
     * 即抽即开奖的核心代码
     * @param lottery  某次抽奖活动的相关设定
     * @param prizeList 奖池
     * @return
     */
    public static Prize spikeLottery(Lottery lottery, List<Prize> prizeList) {
        // 确定活动是否有效,如果活动无效则，直接抽奖失败
        Integer randomCode = random.nextInt(lottery.getCodeScope());
        if (randomCode >= lottery.getWinningStartCode() && randomCode <= lottery.getWinningEndCode()) {
            for (Prize prize : prizeList) {
                if (randomCode >= prize.getStartCode() && randomCode <= prize.getEndCode()) {
                    prize.setHitCode(randomCode);
                    return prize;
                }
            }
        }
        return null;
    }

    /**
     * 定时抽奖的实现
     * 将等待开奖的人群取出来，随机处理
     * @param list 等待群体
     * @param prizes 奖品数量
     * @return
     */
    public static Set<Activitylog> timingLottery(List<WaitActivity> list, List<Prize> prizes) {
        Set<Activitylog> set = new HashSet<>();
        int i = 0;
        Random random = new Random();
        while (true) {
            i = random.nextInt(list.size());
            WaitActivity waitActivity = list.get(i);
            set.add(new Activitylog(waitActivity.getUserId(), waitActivity.getActId(), prizes.get(0).getPrizeId()));
            if (set.size() == prizes.get(0).getPrizeCount()) {
                break;
            }
            list.remove(i);
            if (list.size() == 0) {
                break;
            }
        }
        return set;
    }

}
