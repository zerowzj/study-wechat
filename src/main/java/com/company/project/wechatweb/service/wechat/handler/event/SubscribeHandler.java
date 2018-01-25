package com.company.project.wechatweb.service.wechat.handler.event;

import com.company.project.wechatweb.service.wechat.handler.BaseHandler;
import com.company.project.wechatweb.service.wechat.msg.SubscribeMsg;
import com.company.project.wechatweb.support.wechat.api.msg.TemplateMsgApi;
import com.company.project.wechatweb.support.wechat.api.msg.Value;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 关注
 *
 * @author wangzhj
 */
@Component
public class SubscribeHandler extends BaseHandler<SubscribeMsg> {

    @Override
    public void handle(String openId, SubscribeMsg msg) {
        LOGGER.info("[{}]关注公众号", openId);

        Map<String, Value> data = Maps.newHashMap();
        data.put("mykey", new Value("ffff"));

        TemplateMsgApi.send(openId, "_NRejXL6EnsJ92RbqZKS8hKb6xt7I9UFWzpxChX9o2U", data);
    }

//    @Override
//    public String createMsg(String openId, SubscribeMsg msg) {
//        return "欢迎你关注了公众号";
//    }
}
