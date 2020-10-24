package com.bigliang.e_commerce.po;

import com.bigliang.e_commerce.entity.Activity;
import com.bigliang.e_commerce.entity.Prize;

import java.util.List;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/9/22 0:05
 */

public class ActandPrize {
    private Activity activity;
    private List<Prize> prizeList;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public List<Prize> getPrizeList() {
        return prizeList;
    }

    public void setPrizeList(List<Prize> prizeList) {
        this.prizeList = prizeList;
    }
}
