package com.bigliang.e_commerce.service.impl;

import com.bigliang.e_commerce.entity.Goods;
import com.bigliang.e_commerce.mapper.GoodsMapper;
import com.bigliang.e_commerce.po.PageBean;
import com.bigliang.e_commerce.service.GoodsService;
import com.bigliang.e_commerce.utils.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/10/8 17:08
 */

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public PageBean getAllGoods(int targetPage) {
        PageBean<Goods> pageBean = new PageBean<>();
        if (targetPage == 1) {
            pageBean.setTargetPage(targetPage - 1);
        } else {
            pageBean.setTargetPage((targetPage - 1) * pageBean.getLimit());
        }
        int totalCount = goodsMapper.getTotalCount();
        if (totalCount % pageBean.getLimit() == 0) {
            pageBean.setTotalPage(totalCount / pageBean.getLimit());
        } else {
            pageBean.setTotalPage((totalCount / pageBean.getLimit()) + 1);
        }
        pageBean.setTotalCount(totalCount);
        pageBean.setEntryList(goodsMapper.getAllGoods(pageBean));
        pageBean.setTargetPage(targetPage);
        return pageBean;
    }

    @Override
    public int getTotalCount() {
        return goodsMapper.getTotalCount();
    }

    @Override
    public int addGoods(Goods goods) {
        String goodsID = IDGenerator.getGoodsID();
        goods.setGoodsID(goodsID);
        return goodsMapper.addGoods(goods);
    }

    @Override
    public Goods getGoodsDetails(String goodsID) {
        return goodsMapper.getGoodsDetails(goodsID);
    }

    @Override
    public int delGoods(String goodsID) {
        return goodsMapper.delGoods(goodsID);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsMapper.updateGoods(goods);
    }

    @Override
    public int updateGoodsStatus(Map<String, String> map) {
        return goodsMapper.updateGoodsStatus(map);
    }

    @Override
    public PageBean<Goods> search(Map<String, String> map) {
        PageBean<Goods> pageBean = new PageBean<>();
        int targetPage = Integer.parseInt((map.get("targetPage")));
        pageBean.setTargetPage((targetPage - 1) * pageBean.getLimit());
        int totalCount = goodsMapper.getTotalCount();
        if (totalCount % pageBean.getLimit() == 0) {
            pageBean.setTotalPage(totalCount / pageBean.getLimit());
        } else {
            pageBean.setTotalPage((totalCount / pageBean.getLimit()) + 1);
        }
        pageBean.setTotalCount(totalCount);
        map.put("limit", pageBean.getLimit() + "");
        List<Goods> goods = goodsMapper.search(map, pageBean.getTargetPage(), pageBean.getLimit());
        pageBean.setEntryList(goods);
        return pageBean;
    }
}
