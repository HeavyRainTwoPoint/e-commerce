package com.bigliang.e_commerce.protocol;

/**
 * 描述商品的状态
 */
public interface GoodsStatus {
    /**
     * 上架中
     */
    int ON_SALE = 1;
    /**
     * 下架中
     */
    int OFF_SALE = -1;
    /**
     * 售罄
     */
    int OUT_SALE = 0;
}
