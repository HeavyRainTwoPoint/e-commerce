package com.bigliang.e_commerce.service.impl;

import com.bigliang.e_commerce.entity.Prize;
import com.bigliang.e_commerce.mapper.PrizeMapper;
import com.bigliang.e_commerce.service.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/9/19 15:20
 */

@Service
public class PrizeServiceImpl implements PrizeService {
    @Autowired
    PrizeMapper prizeMapper;

    @Override
    public List<Prize> getAllPrizes(String actID) {
        return prizeMapper.getAllPrizes(actID);
    }

    @Override
    public int addPrizes(List<Prize> list ) {
        return prizeMapper.addPrizes(list);
    }

    @Override
    public int cutPrize(Map<String, String> map) {
        return prizeMapper.cutPrize(map);
    }

    @Override
    public int delPrize(Map<String, String> map) {
        return prizeMapper.delPrize(map);
    }
}
