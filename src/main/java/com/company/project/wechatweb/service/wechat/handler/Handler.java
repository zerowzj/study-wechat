package com.company.project.wechatweb.service.wechat.handler;

import com.company.project.wechatweb.service.wechat.msg.Msg;

/**
 * 业务逻辑
 *
 * @author wangzhj
 */
public interface Handler<T extends Msg> {

    /**
     * 执行业务
     *
     * @param msg
     */
    void doHandle(T msg);
}
