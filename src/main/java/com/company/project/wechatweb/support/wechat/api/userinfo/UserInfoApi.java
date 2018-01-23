package com.company.project.wechatweb.support.wechat.api.userinfo;

import com.company.project.wechatweb.support.util.JsonUtil;
import com.company.project.wechatweb.support.wechat.api.token.TokenApi;
import com.github.kevinsawicki.http.HttpRequest;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 用户信息Api
 *
 * @author wangzhj
 */
public class UserInfoApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoApi.class);

    private static final String URL = "https://api.weixin.qq.com/cgi-bin/user/info";

    private static final String LANG = "zh_CN";

    /**
     * 获取用户信息
     *
     * @param openId
     * @return UserInfoResp
     */
    public static UserInfoResp getUserInfo(String openId) {
        //验证
        Preconditions.checkNotNull(openId);
        //参数
        Map<String, String> params = Maps.newHashMap();
        params.put("access_token", TokenApi.getAccessToken());
        params.put("openid", openId);
        params.put("lang", LANG);
        //请求
        HttpRequest request = HttpRequest.post(URL, params, false);
        UserInfoResp userInfo = null;
        if (request.ok()) {
            String body = request.body();
            LOGGER.info("{}", body);
            userInfo = JsonUtil.fromJson(body, UserInfoResp.class);
        }
        return userInfo;
    }
}

