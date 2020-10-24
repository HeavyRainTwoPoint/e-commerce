package com.bigliang.e_commerce.mapper;

import com.bigliang.e_commerce.entity.Goods;
import com.bigliang.e_commerce.po.PageBean;
import javafx.beans.binding.MapExpression;

import java.util.List;
import java.util.Map;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/10/4 22:57
 */

public interface GoodsMapper {
    /**
     * 获取所有的商品，但是商品的属性信息只有部分
     * @return
     */
    public List<Goods> getAllGoods(PageBean<Goods> pageBean);

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
     * @param map 提供GoodsStatus、goodsID
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
    List<Goods> search(Map<String, String> map, int targetPage, int limit);
}
