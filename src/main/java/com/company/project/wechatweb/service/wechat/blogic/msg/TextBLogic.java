package com.company.project.wechatweb.service.wechat.blogic.msg;

import com.company.project.wechatweb.service.wechat.blogic.BaseBLogic;
import com.company.project.wechatweb.service.wechat.msg.TextMsg;
import org.springframework.stereotype.Component;

/**
 * 文本消息
 *
 * @author wangzhj
 */
@Component
public class TextBLogic extends BaseBLogic<TextMsg> {

    @Override
    public String createMsg(String openId, TextMsg msg) {
        LOGGER.info("[{}]发送文本消息[{}]", openId, msg.getContent());
        return "你发的是: " + msg.getContent();
    }

    @Override
    public void processBusiness(String openId, TextMsg msg) {

    }
}
