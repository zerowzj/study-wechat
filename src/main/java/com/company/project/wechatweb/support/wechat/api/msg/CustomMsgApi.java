package com.company.project.wechatweb.support.wechat.api.msg;

import com.company.project.wechatweb.support.util.JsonUtil;
import com.company.project.wechatweb.support.wechat.api.token.TokenApi;
import com.github.kevinsawicki.http.HttpRequest;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 客服消息Api
 *
 * @author wangzhj
 */
public class CustomMsgApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomMsgApi.class);

    private static final String URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send";

    /**
     * 发送消息
     *
     * @param openId
     * @param content
     */
    public static void send(String openId, String content) {
        //验证
        Preconditions.checkNotNull(openId);
        Preconditions.checkNotNull(content);
        //参数
        Map<String, Object> data = Maps.newHashMap();
        data.put("touser", openId);
        data.put("msgtype", "text");
        Map<String, String> context = Maps.newHashMap();
        context.put("content", content);
        data.put("text", context);
        //Url
        StringBuffer myUrl = new StringBuffer(URL);
        myUrl.append("?access_token=")
                .append(TokenApi.getAccessToken());
        //请求
        LOGGER.info("发送客服消息===>{}", JsonUtil.toJson(data));
        HttpRequest request = HttpRequest.post(myUrl)
                .contentType("application/json", "UTF-8")
                .send(JsonUtil.toJson(data));
        LOGGER.info("code={}", request.code());
        if (request.ok()) {
            LOGGER.info("发送客服消息<==={}", request.body());
        }
    }
}
