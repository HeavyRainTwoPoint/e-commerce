package com.bigliang.e_commerce.mapper;

import com.bigliang.e_commerce.entity.Lottery;

import java.util.Map;

public interface LotteryMapper {
    public Lottery getLotteryByActID(String actID);

    public int addLottery(Lottery lottery);

    public int delLottery(String actID);
}
