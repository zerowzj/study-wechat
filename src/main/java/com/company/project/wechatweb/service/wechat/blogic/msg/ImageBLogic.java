package com.company.project.wechatweb.service.wechat.blogic.msg;

import com.company.project.wechatweb.service.wechat.blogic.BaseBLogic;
import com.company.project.wechatweb.service.wechat.msg.ImageMsg;
import org.springframework.stereotype.Component;

/**
 * 文本消息
 *
 * @author wangzhj
 */
@Component
public class ImageBLogic extends BaseBLogic<ImageMsg> {

    @Override
    public String createMsg(String openId, ImageMsg msg) {
        return "你上传的是什么？";
    }

    @Override
    public void processBusiness(String openId, ImageMsg msg) {
        LOGGER.info("sdfsdfsdf");
    }
}
