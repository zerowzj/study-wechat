package com.company.project.wechatweb.service.wechat.handler.event;

import com.company.project.wechatweb.service.wechat.handler.BaseHandler;
import com.company.project.wechatweb.service.wechat.msg.SubscribeMsg;
import org.springframework.stereotype.Component;

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
    }

    @Override
    public String createMsg(String openId, SubscribeMsg msg) {
        return "欢迎你关注了公众号";
    }
}
