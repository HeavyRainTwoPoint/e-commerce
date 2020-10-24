package com.bigliang.e_commerce.service;

import com.bigliang.e_commerce.entity.Prize;

import java.util.List;
import java.util.Map;

public interface PrizeService {
    public List<Prize> getAllPrizes(String actID);
    public int addPrizes(List<Prize> list);
    public int cutPrize(Map<String, String> map);
    public int delPrize(Map<String, String> map);
}
