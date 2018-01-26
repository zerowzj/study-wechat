package com.company.project.wechatweb.service.wechat.handler.msg;

import com.company.project.wechatweb.service.wechat.handler.BaseHandler;
import com.company.project.wechatweb.service.wechat.msg.TextMsg;
import com.company.project.wechatweb.support.wechat.api.msg.TemplateMsgApi;
import com.company.project.wechatweb.support.wechat.api.msg.Value;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 文本
 *
 * @author wangzhj
 */
@Component
public class TextHandler extends BaseHandler<TextMsg> {

//    @Override
//    public String createMsg(String openId, TextMsg msg) {
//        LOGGER.info("[{}]发送文本消息[{}]", openId, msg.getContent());
//        return "你发的是: " + msg.getContent();
//    }

    @Override
    public void handle(String openId, TextMsg msg) {

        Map<String, Value> data = Maps.newHashMap();
        data.put("mykey", new Value("100元"));

        TemplateMsgApi.send(openId, "_NRejXL6EnsJ92RbqZKS8hKb6xt7I9UFWzpxChX9o2U", "http://www.sohu.com");
    }
}
