package com.company.project.wechatweb.support.wechat.api.token;

import com.company.project.wechatweb.support.util.JsonUtil;
import com.company.project.wechatweb.support.util.WechatConfig;
import com.github.kevinsawicki.http.HttpRequest;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Token Api
 *
 * @author wangzhj
 */
public class TokenApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenApi.class);

    private static final String URL = "https://api.weixin.qq.com/cgi-bin/token";

    private static String accessToken;

    private static long overTimeMillis = -1;

    /**
     * 获取Access TokenResp
     *
     * @return String
     */
    public synchronized static String getAccessToken() {
        long now = System.currentTimeMillis();
        if (overTimeMillis <= now) {
            doGet();
        }
        if (Strings.isNullOrEmpty(accessToken)) {
            throw new IllegalStateException("未获取到[token]");
        }
        return accessToken;
    }

    private synchronized static void doGet() {
        //生成参数
        Map<String, String> params = Maps.newHashMap();
        params.put("grant_type", "client_credential");
        params.put("appid", WechatConfig.getAppId());
        params.put("secret", WechatConfig.getSecret());
        //
        LOGGER.info("获取Token==>{}", JsonUtil.toJson(params));
        HttpRequest request = HttpRequest.get(URL, params, false);
        TokenResp token = null;
        if (request.ok()) {
            String body = request.body();
            LOGGER.info("获取Token<==={}", body);
            token = JsonUtil.fromJson(body, TokenResp.class);
        }
        if (token != null && token.ok()) {
            overTimeMillis = System.currentTimeMillis() + token.getExpires_in() * 1000;
            accessToken = token.getAccess_token();
        }
    }
}
