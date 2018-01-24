package com.company.project.wechatweb.service.wechat.blogic;

import com.company.project.wechatweb.service.wechat.msg.SubscribeMsg;
import org.springframework.stereotype.Component;

/**
 * 取消关注事件
 *
 * @author wangzhj
 */
@Component
public class UnsubscribeBLogic extends BaseBLogic<SubscribeMsg> {

    @Override
    public void processBusiness(String openId, SubscribeMsg msg) {

    }
}
