package com.company.project.wechatweb.support.wechat.api.msg;

import com.company.project.wechatweb.support.util.JsonUtil;
import com.company.project.wechatweb.support.wechat.api.token.TokenApi;
import com.github.kevinsawicki.http.HttpRequest;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
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

    public static void send(String openId, String templateId) {
        send(openId, templateId, null, null);
    }

    public static void send(String openId, String templateId, String url) {
        send(openId, templateId, url, null);
    }

    public static void send(String openId, String templateId, Map<String, Value> data) {
        send(openId, templateId, null, data);
    }

    /**
     * 发送消息
     *
     * @param openId     接收者openid
     * @param templateId 接收者openid
     * @param url        接收者openid
     * @param data       模板数据
     */
    public static void send(String openId, String templateId, String url, Map<String, Value> data) {
        //验证
        Preconditions.checkNotNull(openId);
        Preconditions.checkNotNull(templateId);
        //参数
        Map<String, Object> params = Maps.newHashMap();
        params.put("touser", openId);
        params.put("template_id", templateId);
        if (!Strings.isNullOrEmpty(url)) {
            params.put("url", url);
        }
        if (data != null) {
            params.put("data", data);
        }
        //URL
        StringBuffer myUrl = new StringBuffer(URL);
        myUrl.append("?access_token=")
                .append(TokenApi.getAccessToken());
        //请求
        LOGGER.info("发送模板消息==>{}", JsonUtil.toJson(params));
        HttpRequest request = HttpRequest.post(myUrl)
                .send(JsonUtil.toJson(params));
        //响应
        LOGGER.info("status code={}", request.code());
        if (request.ok()) {
            LOGGER.info("发送模板消息<=={}", request.body());
        }
    }

    public static void main(String[] args) {
        String openId = "oeAbiwxhpKI3NHeE3rJOywaLsN1g";
        String templateId = "_NRejXL6EnsJ92RbqZKS8hKb6xt7I9UFWzpxChX9o2U";
        String url = "";
        Map<String, Value> data = Maps.newHashMap();
        data.put("mykey", new Value("10000"));
        send(openId, templateId, url, data);
    }
}
