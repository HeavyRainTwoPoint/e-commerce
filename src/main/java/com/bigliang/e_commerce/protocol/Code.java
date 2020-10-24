package com.bigliang.e_commerce.protocol;

/**
 * @author 大雨两点
 * 状态码
 */
public interface Code {
    /**
     * 一等奖代号
     */
    long First_PRICE = 2001;
    /**
     * 二等奖状态
     */
    long SECOND_PRICE = 2002;
    /**
     * 三等奖代号
     */
    long THIRD_PRICE = 2003;
    /**
     * 谢谢惠顾代号
     */
    long FOURTH_PRICE = 2004;

    //-----------------分割线，上面为秒杀抽奖状态码，下面为定时抽奖参与相关状态码

    /**
     * 参与成功代号
     */
    long JOIN_SUCCESS = 2005;
    /**
     * 参与失败代号
     */
    long JOIN_FAIL = 4001;
    /**
     * 拒绝参与代号（未开始）
     */
    long JOIN_REJECT = 4002;
    /**
     * 参与时异常代号
     */
    long JOIN_EXCEPTION = 4004;
}
