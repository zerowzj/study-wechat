package com.company.project.wechatweb.service.wechat.handler.event;

import com.company.project.wechatweb.service.wechat.handler.BaseHandler;
import com.company.project.wechatweb.service.wechat.msg.SubscribeMsg;
import org.springframework.stereotype.Component;

/**
 * 取消关注
 *
 * @author wangzhj
 */
@Component
public class UnsubscribeHandler extends BaseHandler<SubscribeMsg> {

    @Override
    public void handle(String openId, SubscribeMsg msg) {
        LOGGER.info("[{}]取消了关注公众号", openId);
    }
}
