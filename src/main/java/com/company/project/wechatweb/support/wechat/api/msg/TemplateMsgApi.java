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
 * 模板消息Api
 *
 * @author wangzhj
 */
public class TemplateMsgApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateMsgApi.class);

    private static final String URL = "https://api.weixin.qq.com/cgi-bin/message/template/send";

    /**
     * 发送消息
     *
     * @param openId
     * @param templateId
     * @param data
     */
    public static void send(String openId, String templateId, Map<String, Value> data) {
        //验证
        Preconditions.checkNotNull(openId);
        Preconditions.checkNotNull(templateId);
        Preconditions.checkNotNull(data);
        //参数
        Map<String, Object> body = Maps.newHashMap();
        body.put("touser", openId);
        body.put("template_id", templateId);
        String json = JsonUtil.toJson(data);
        body.put("data", json);
        //Url
        StringBuffer myUrl = new StringBuffer(URL);
        myUrl.append("?access_token=");
        myUrl.append(TokenApi.getAccessToken());
        //请求
        LOGGER.info("发送模板消息===>{}", json);
        HttpRequest request = HttpRequest.post(myUrl)
                .contentType("application/json", "UTF-8")
                .send(JsonUtil.toJson(body));
        LOGGER.info("code={}", request.code());
        if (request.ok()) {
            LOGGER.info("发送模板消息<==={}", request.body());
        }
    }
}
