package com.bigliang.e_commerce.po;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/9/23 23:05
 */

public class BackTo {
    private boolean result;
    private String message;
    private long code;
    private String token;

    public BackTo(){}

    public BackTo(boolean result, String message, long code) {
        this.result = result;
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public BackTo(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
