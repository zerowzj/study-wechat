package com.company.project.wechatweb.support.wechat.api.token;

import com.company.project.wechatweb.support.util.JsonUtil;
import com.company.project.wechatweb.support.wechat.config.WechatCfg;
import com.github.kevinsawicki.http.HttpRequest;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Token Api
 *
 * @author wangzhj
 */
public class TokenApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenApi.class);

    private static final String URL = "https://api.weixin.qq.com/cgi-bin/token";

    /* Token */
    private static String ACCESS_TOKEN;
    /* 过期时间（毫秒） */
    private static long OVER_TIME_MILLIS = -1;

    static {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

            }
        }, 7200 * 1000);
    }

    /**
     * 获取Access Token
     *
     * @return String
     */
    public synchronized static String getAccessToken() {
        long now = System.currentTimeMillis();
        if (OVER_TIME_MILLIS <= now) {
            doGet();
        }
        if (Strings.isNullOrEmpty(ACCESS_TOKEN)) {
            throw new IllegalStateException("未获取到[token]");
        }
        return ACCESS_TOKEN;
    }

    private synchronized static void doGet() {
        //生成参数
        Map<String, String> params = Maps.newHashMap();
        params.put("grant_type", "client_credential");
        params.put("appid", WechatCfg.getAppId());
        params.put("secret", WechatCfg.getSecret());
        //
        LOGGER.info("获取access token==>{}", JsonUtil.toJson(params));
        HttpRequest request = HttpRequest.get(URL, params, false);
        LOGGER.info("status code={}", request.code());
        TokenResp tokenResp = null;
        if (request.ok()) {
            String body = request.body();
            LOGGER.info("获取access token<=={}", body);
            tokenResp = JsonUtil.fromJson(body, TokenResp.class);
        }
        if (tokenResp != null && tokenResp.ok()) {
            OVER_TIME_MILLIS = System.currentTimeMillis() + tokenResp.getExpires_in() * 1000;
            ACCESS_TOKEN = tokenResp.getAccess_token();
        }
    }

    public static void main(String[] args) {
        getAccessToken();
    }
}
