package com.bigliang.e_commerce.utils;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/9/12 15:10
 */

public class TokenUtil {
    public static String token() {
        return RandomStringUtils.randomAlphanumeric(8) + System.currentTimeMillis();
    }
}
