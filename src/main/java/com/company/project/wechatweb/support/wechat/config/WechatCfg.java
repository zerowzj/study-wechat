package com.company.project.wechatweb.support.wechat.config;

import java.io.InputStream;
import java.util.Properties;

/**
 * 微信配置
 *
 * @author wangzhj
 */
public final class WechatCfg {

    private static final String FILE = "/wechat.properties";

    private static Properties PROP;

    static {
        try {
            InputStream in = WechatCfg.class.getResourceAsStream(FILE);
            PROP = new Properties();
            PROP.load(in);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 获取AppId
     *
     * @return String
     */
    public static String getAppId() {
        return PROP.getProperty("app_id");
    }

    /**
     * 获取Secret
     *
     * @return String
     */
    public static String getSecret() {
        return PROP.getProperty("secret");
    }

    /**
     * 获取Token
     *
     * @return String
     */
    public static String getToken() {
        return PROP.getProperty("token");
    }

    public static void main(String[] args) {
        System.out.println(getAppId());
        System.out.println(getSecret());
        System.out.println(getToken());
    }
}
