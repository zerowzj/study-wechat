package com.company.project.wechatweb.support.wechat.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 微信Js配置
 *
 * @author wangzhj
 */
public final class WechatJsCfg {

    /**
     * 生成时间戳
     */
    public static String createTimestamp() {
        return "";
    }

    /**
     * 生成随机串
     */
    public static String createNonceStr() {
        return "";
    }

    /**
     * 计算签名
     */
    public static String getSign(String url) {
        List<String> src = Arrays.asList(WechatJsCfg.createTimestamp(), WechatJsCfg.createNonceStr());
        Collections.sort(src);
        return "";
    }
}
