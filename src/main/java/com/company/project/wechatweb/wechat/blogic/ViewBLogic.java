package com.company.project.wechatweb.wechat.blogic;

import com.company.project.wechatweb.wechat.msg.MenuMsg;
import org.springframework.stereotype.Component;

/**
 * 跳转Url
 *
 * @author wangzhj
 */
@Component
public class ViewBLogic extends BaseBLogic<MenuMsg> {

    @Override
    public String createMsg(String openId, MenuMsg msg) {
        LOGGER.info("用户[{}]跳转了[{}]", msg.getFromUserName(), msg.getEventKey());
        return null;
    }

    @Override
    public void processBusiness(String openId, MenuMsg msg) {

    }
}
