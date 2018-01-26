package com.company.project.wechatweb.support.wechat.api.token;

import com.company.project.wechatweb.support.util.JsonUtil;
import com.company.project.wechatweb.support.util.WechatCfg;
import com.github.kevinsawicki.http.HttpRequest;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 认证Token
 *
 * @author wangzhj
 */
public class AuthTokenApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthTokenApi.class);

    private static final String URL = "https://api.weixin.qq.com/sns/oauth2/access_token";

    private static final String GRANT_TYPE = "authorization_code";

    private static final String APP_ID = WechatCfg.getAppId();

    private static final String SECRET = WechatCfg.getSecret();

    private static AuthTokenResp token;

    private static long overTimeMillis = -1;

    /**
     * 获取Access Token
     *
     * @param code
     * @return String
     */
    public static AuthTokenResp getAccessToken(String code) {
        long now = System.currentTimeMillis();
        if (overTimeMillis <= now) {
            LOGGER.info("请求获取[access token]");
            doGetToken(code);
        }
        if (token == null) {
            throw new IllegalStateException("未获取到[access token]");
        }
        return token;
    }

    private static void doGetToken(String code) {
        Map<String, String> params = Maps.newHashMap();
        params.put("grant_type", GRANT_TYPE);
        params.put("appid", APP_ID);
        params.put("secret", SECRET);
        params.put("code", code);
        HttpRequest request = HttpRequest.get(URL, params, false);
        if (request.ok()) {
            String body = request.body();
            LOGGER.info(body);
            token = JsonUtil.fromJson(body, AuthTokenResp.class);
        }
        if (token != null && token.ok()) {
            overTimeMillis = System.currentTimeMillis() + token.getExpires_in() * 1000;
        }
    }
}
