package com.company.project.wechatweb.service.wechat.blogic.event;

import com.company.project.wechatweb.service.wechat.blogic.BaseBLogic;
import com.company.project.wechatweb.service.wechat.msg.SubscribeMsg;
import org.springframework.stereotype.Component;

/**
 * 关注
 *
 * @author wangzhj
 */
@Component
public class SubscribeBLogic extends BaseBLogic<SubscribeMsg> {

    @Override
    public void processBusiness(String openId, SubscribeMsg msg) {
        LOGGER.info("[{}]关注公众号", openId);
    }

    @Override
    public String createMsg(String openId, SubscribeMsg msg) {
        return "欢迎你关注了公众号";
    }
}
