package com.company.project.wechatweb.support.util;

import java.io.InputStream;
import java.util.Properties;

/**
 * 微信参数配置
 *
 * @author wangzhj
 */
public final class WechatConfig {

    private static final String FILE = "/wechat.properties";

    private static Properties PROP;

    static {
        try {
            InputStream in = WechatConfig.class.getResourceAsStream(FILE);
            PROP = new Properties();
            PROP.load(in);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String getAppId() {
        return PROP.getProperty("app_id");
    }

    public static String getSecret() {
        return PROP.getProperty("secret");
    }

    public static String getToken() {
        return PROP.getProperty("token");
    }

    public static void main(String[] args) {
        System.out.println(getAppId());
    }
}
