package com.bigliang.e_commerce.controller;

import com.bigliang.e_commerce.entity.Goods;
import com.bigliang.e_commerce.po.BackTo;
import com.bigliang.e_commerce.po.PageBean;
import com.bigliang.e_commerce.protocol.GoodsStatus;
import com.bigliang.e_commerce.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/10/8 17:29
 */

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @PostMapping("/allGoods")
    public PageBean allGoods(@RequestBody Map<String, Integer> map) {
        return goodsService.getAllGoods(map.get("targetPage"));
    }

    @PostMapping("/addGoods")
    public BackTo addGoods(@RequestBody Goods goods) {
        int result = goodsService.addGoods(goods);
        return result == 1 ? new BackTo(true, "成功添加一个商品！", 200) : new BackTo(false, "添加失败！请重试！", 500);
    }

    @PostMapping("/details")
    public Goods details(@RequestBody Map<String, String> map) {
        return goodsService.getGoodsDetails(map.get("goodsID"));
    }

    @PostMapping("/delGoods")
    public BackTo delGoods(@RequestBody Map<String, String> map) {
        int result = goodsService.delGoods(map.get("goodsID"));
        if (result == 1) {
            return new BackTo(true, "成功删除一个商品！", 200);
        } else {
            return new BackTo(false, "删除商品失败！请重试！", 200);
        }
    }

    @PostMapping("/updateStatus")
    public BackTo updateStatus(@RequestBody Map<String, String> map) {
        int result = goodsService.updateGoodsStatus(map);
        int status = Integer.parseInt(map.get("goodsStatus"));
        if (result == 1) {
            return new BackTo(true, getMessage(status), 200);
        } else {
            return new BackTo(false, "操作失败！请重试！", 200);
        }
    }

    @PostMapping("/search")
    public PageBean<Goods> search(@RequestBody Map<String, String> map) {
        return goodsService.search(map);
    }


    public String getMessage(int status) {
        switch (status) {
            case GoodsStatus.OFF_SALE:
                return "商品下架成功！";
            case GoodsStatus.ON_SALE:
                return "商品上架成功！";
            case GoodsStatus.OUT_SALE:
                return "商品改为售罄状态！";
            default:
                return "参数错误！";
        }
    }
}
