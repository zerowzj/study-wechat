package com.company.project.wechatweb.service.wechat.blogic;

import com.company.project.wechatweb.service.wechat.msg.MenuMsg;
import org.springframework.stereotype.Component;

/**
 * 跳转Url
 *
 * @author wangzhj
 */
@Component
public class ViewBLogic extends BaseBLogic<MenuMsg> {

    @Override
    public void processBusiness(String openId, MenuMsg msg) {
        LOGGER.info("用户[{}]跳转了[{}]", msg.getFromUserName(), msg.getEventKey());
    }
}
