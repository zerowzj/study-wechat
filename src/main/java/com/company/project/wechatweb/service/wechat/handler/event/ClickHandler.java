package com.company.project.wechatweb.service.wechat.handler.event;

import com.company.project.wechatweb.service.wechat.handler.BaseHandler;
import com.company.project.wechatweb.service.wechat.msg.MenuMsg;
import org.springframework.stereotype.Component;

/**
 * 自定义
 *
 * @author wangzhj
 */
@Component
public class ClickHandler extends BaseHandler<MenuMsg> {

    @Override
    public void handle(String openId, MenuMsg msg) {
        LOGGER.info("用户[{}]点击[{}]", msg.getFromUserName(), msg.getEventKey());
    }
}
