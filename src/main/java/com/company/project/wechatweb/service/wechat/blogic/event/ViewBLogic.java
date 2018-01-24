package com.company.project.wechatweb.service.wechat.blogic.event;

import com.company.project.wechatweb.service.wechat.blogic.BaseBLogic;
import com.company.project.wechatweb.service.wechat.msg.MenuMsg;
import org.springframework.stereotype.Component;

/**
 * URL跳转
 *
 * @author wangzhj
 */
@Component
public class ViewBLogic extends BaseBLogic<MenuMsg> {

    @Override
    public void processBusiness(String openId, MenuMsg msg) {
        LOGGER.info("用户[{}]跳转[{}]", msg.getFromUserName(), msg.getEventKey());
    }
}
