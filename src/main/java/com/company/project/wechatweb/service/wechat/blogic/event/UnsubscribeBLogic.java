package com.company.project.wechatweb.service.wechat.blogic.event;

import com.company.project.wechatweb.service.wechat.blogic.BaseBLogic;
import com.company.project.wechatweb.service.wechat.msg.SubscribeMsg;
import org.springframework.stereotype.Component;

/**
 * 取消关注
 *
 * @author wangzhj
 */
@Component
public class UnsubscribeBLogic extends BaseBLogic<SubscribeMsg> {

    @Override
    public void processBusiness(String openId, SubscribeMsg msg) {
        LOGGER.info("[{}]取消了关注公众号", openId);
    }
}
