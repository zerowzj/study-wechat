package com.company.project.wechatweb.support.wechat.config;

import com.fasterxml.uuid.Generators;
import org.joda.time.DateTime;

import java.util.UUID;

/**
 * 微信Js配置
 *
 * @author wangzhj
 */
public final class WechatJsParams {

    /**
     * 生成时间戳
     *
     * @return String
     */
    public static String createTimestamp() {
        long timestamp = DateTime.now().getMillis();
        return String.valueOf(timestamp);
    }

    /**
     * 生成随机串
     *
     * @return String
     */
    public static String createNonceStr() {
        UUID uuid = Generators.timeBasedGenerator().generate();
        uuid.timestamp();
        return "";
    }

    public static void main(String[] args) {
        UUID uuid = Generators.timeBasedGenerator().generate();
        uuid.timestamp();
        System.out.println(uuid);
        System.out.println(DateTime.now().getMillis());
        System.out.println(System.currentTimeMillis());
    }
}
