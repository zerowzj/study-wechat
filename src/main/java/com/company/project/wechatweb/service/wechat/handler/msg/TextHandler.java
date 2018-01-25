package com.company.project.wechatweb.service.wechat.handler.msg;

import com.company.project.wechatweb.service.wechat.handler.BaseHandler;
import com.company.project.wechatweb.service.wechat.msg.TextMsg;
import org.springframework.stereotype.Component;

/**
 * 文本消息
 *
 * @author wangzhj
 */
@Component
public class TextHandler extends BaseHandler<TextMsg> {

    @Override
    public String createMsg(String openId, TextMsg msg) {
        LOGGER.info("[{}]发送文本消息[{}]", openId, msg.getContent());
        return "你发的是: " + msg.getContent();
    }

    @Override
    public void handle(String openId, TextMsg msg) {

    }
}
