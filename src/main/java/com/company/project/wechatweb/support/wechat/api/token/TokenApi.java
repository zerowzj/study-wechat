package com.company.project.wechatweb.support.wechat.api.token;

import com.company.project.wechatweb.support.util.JsonUtil;
import com.company.project.wechatweb.support.util.WechatCfg;
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
     * 获取Access Token
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
        params.put("appid", WechatCfg.getAppId());
        params.put("secret", WechatCfg.getSecret());
        //
        LOGGER.info("获取access_token==>{}", JsonUtil.toJson(params));
        HttpRequest request = HttpRequest.get(URL, params, false);
        LOGGER.info("StatusCode={}", request.code());
        TokenResp token = null;
        if (request.ok()) {
            String body = request.body();
            LOGGER.info("获取access_token<=={}", body);
            token = JsonUtil.fromJson(body, TokenResp.class);
        }
        if (token != null && token.ok()) {
            overTimeMillis = System.currentTimeMillis() + token.getExpires_in() * 1000;
            accessToken = token.getAccess_token();
        }
    }

    public static void main(String[] args) {
        getAccessToken();
    }
}
