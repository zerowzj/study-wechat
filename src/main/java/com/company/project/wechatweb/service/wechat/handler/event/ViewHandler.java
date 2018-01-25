package com.company.project.wechatweb.service.wechat.handler.event;

import com.company.project.wechatweb.service.wechat.handler.BaseHandler;
import com.company.project.wechatweb.service.wechat.msg.MenuMsg;
import org.springframework.stereotype.Component;

/**
 * URL跳转
 *
 * @author wangzhj
 */
@Component
public class ViewHandler extends BaseHandler<MenuMsg> {

    @Override
    public void handle(String openId, MenuMsg msg) {
        LOGGER.info("用户[{}]跳转[{}]", msg.getFromUserName(), msg.getEventKey());
    }
}
