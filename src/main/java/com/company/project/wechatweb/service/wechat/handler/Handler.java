package com.company.project.wechatweb.service.wechat.handler;

import com.company.project.wechatweb.service.wechat.msg.Msg;

/**
 * 处理器
 *
 * @author wangzhj
 */
public interface Handler<T extends Msg> {

    /**
     * 执行
     *
     * @param msg
     */
    void doHandle(T msg);
}
