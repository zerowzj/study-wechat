package com.company.project.wechatweb.service.wechat.handler;

import com.company.project.wechatweb.service.wechat.msg.Msg;

/**
 * 微信Msg处理器
 *
 * @author wangzhj
 */
public interface Handler<T extends Msg> {

    /**
     * 处理
     *
     * @param msg
     */
    void doHandle(T msg);
}
