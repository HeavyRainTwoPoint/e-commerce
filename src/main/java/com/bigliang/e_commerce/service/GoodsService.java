package com.bigliang.e_commerce.service;

import com.bigliang.e_commerce.entity.Goods;
import com.bigliang.e_commerce.po.PageBean;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    /**
     * 分页获取商品信息，但是仅显示部分属性信息
     * @return
     */
    public PageBean getAllGoods(int targetPage);

    /**
     * 获取条目总数
     * @return
     */
    public int getTotalCount();

    /**
     * 添加商品
     * @param goods
     * @return
     */
    public int addGoods(Goods goods);

    /**
     * 获取商品的详细信息
     * @param goodsID
     * @return
     */
    public Goods getGoodsDetails(String goodsID);

    /**
     * 删除商品
     * @param goodsID
     * @return
     */
    public int delGoods(String goodsID);

    /**
     * 更新商品信息
     * @param goods
     * @return
     */
    public int updateGoods(Goods goods);

    /**
     * 更新货物状态
     * @param map 提供goodsStatus、goodsID
     * @return
     */
    public int updateGoodsStatus(Map<String, String> map);

    /**
     * 按条件查找
     * @param map 封装着各种参数
     *             goodsID， goodsName，categoryID
     *             goodsStatus， referToBrand
     *             targetPage， limit 
     * @return
     */
    PageBean search(Map<String, String> map);
}
