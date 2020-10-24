package com.bigliang.e_commerce.po;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/10/4 10:26
 */

public class LotteryResult {
    private boolean result;
    private String message;
    private int code;

    public LotteryResult(boolean result, String message, int code) {
        this.code = code;
        this.message = message;
        this.result = result;
    }
    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
