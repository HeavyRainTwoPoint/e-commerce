package com.bigliang.e_commerce.protocol;

public interface OrderStatus {
    /**
     * 待确认
     */
    int ORDER_COMFIRMING = 3;
    /**
     * 配送中
     */
    int ORDER_DELIVERY = 2;
    /**
     * 订单已完成
     */
    int ORDER_COMPLETED = 1;
    /**
     * 订单已关闭
     */
    int ORDER_CLOSE = 0;
    /**
     * 退货受理中
     */
    int ORDER_RETURN = -1;
    /**
     * 退货处理完毕
     */
    int ORDER_OVER = -2;
}
