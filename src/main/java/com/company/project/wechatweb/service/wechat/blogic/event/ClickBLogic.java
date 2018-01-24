package com.company.project.wechatweb.service.wechat.blogic.event;

import com.company.project.wechatweb.service.wechat.blogic.BaseBLogic;
import com.company.project.wechatweb.service.wechat.msg.MenuMsg;
import org.springframework.stereotype.Component;

/**
 * 自定义
 *
 * @author wangzhj
 */
@Component
public class ClickBLogic extends BaseBLogic<MenuMsg> {

    @Override
    public void processBusiness(String openId, MenuMsg msg) {
        LOGGER.info("用户[{}]点击[{}]", msg.getFromUserName(), msg.getEventKey());
    }
}
