package com.company.project.wechatweb.service.wechat.blogic;

import com.company.project.wechatweb.service.wechat.msg.Msg;

/**
 * 业务逻辑
 *
 * @author wangzhj
 */
public interface BLogic<T extends Msg> {

    /**
     * 执行业务
     *
     * @param msg
     */
    void doBusiness(T msg);
}
