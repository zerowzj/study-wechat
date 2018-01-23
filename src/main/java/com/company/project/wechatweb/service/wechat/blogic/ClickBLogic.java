package com.company.project.wechatweb.service.wechat.blogic;

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
    public String createMsg(String openId, MenuMsg msg) {
        return null;
    }

    @Override
    public void processBusiness(String openId, MenuMsg msg) {
    }
}
