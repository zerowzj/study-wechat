package com.company.project.wechatweb.service.wechat.handler.msg;

import com.company.project.wechatweb.service.wechat.handler.BaseHandler;
import com.company.project.wechatweb.service.wechat.msg.ImageMsg;
import org.springframework.stereotype.Component;

/**
 * 文本消息
 *
 * @author wangzhj
 */
@Component
public class ImageHandler extends BaseHandler<ImageMsg> {

    @Override
    public String createMsg(String openId, ImageMsg msg) {
        return "你上传的是什么？";
    }

    @Override
    public void handle(String openId, ImageMsg msg) {
        LOGGER.info("sdfsdfsdf");
    }
}
