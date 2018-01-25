package com.company.project.wechatweb.service.wechat.handler;

import com.company.project.wechatweb.service.wechat.msg.Msg;
import com.company.project.wechatweb.support.wechat.api.msg.CustomMsgApi;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

/**
 * 基本处理器
 *
 * @author wangzhj
 */
public abstract class BaseHandler<T extends Msg> implements Handler<T> {

    protected static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public final void doHandle(T msg) {
        try {
            //获取OpenId
            String openId = msg.getFromUserName();
            //进行处理
            handle(openId, msg);
            //发送消息
            String content = createMsg(openId, msg);
            if (!Strings.isNullOrEmpty(content)) {
                CustomMsgApi.send(msg.getFromUserName(), content);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 生成消息
     *
     * @param msg
     */
    public String createMsg(String openId, T msg) {
        return null;
    }

    /**
     * 处理业务
     *
     * @param msg
     */
    public abstract void handle(String openId, T msg);
}
