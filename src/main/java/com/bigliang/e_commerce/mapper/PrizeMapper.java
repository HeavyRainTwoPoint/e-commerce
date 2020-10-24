package com.bigliang.e_commerce.mapper;

import com.bigliang.e_commerce.entity.Prize;

import java.util.List;
import java.util.Map;

public interface PrizeMapper {
    /**
     * 获取某个活动的全部奖项
     * @param actID
     * @return
     */
    public List<Prize> getAllPrizes(String actID);

    /**
     * 添加奖品
     * @param list
     * @return
     */
    public int addPrizes(List<Prize> list);

    /**
     * 中奖之后需要修改奖品数量
     * @param map
     * @return
     */
    public int cutPrize(Map<String, String> map);

    /**
     * 活动被删除的时候也相应地将隶属该次活动的奖品删除
     * @param map
     * @return
     */
    public int delPrize(Map<String, String> map);
}
