package com.company.project.wechatweb.service.wechat.msg;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 关注/取消关注事件消息
 *
 * @author wangzhj
 */
@XStreamAlias("xml")
public class SubscribeMsg extends Msg {

    //事件类型，subscribe(订阅)、unsubscribe(取消订阅)
    private String Event;

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }
}
