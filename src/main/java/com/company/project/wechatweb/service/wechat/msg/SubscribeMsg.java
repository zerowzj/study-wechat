package com.company.project.wechatweb.service.wechat.msg;

/**
 * 关注/取消关注事件消息
 *
 * @author wangzhj
 */
//@XStreamAlias("xml")
public class SubscribeMsg extends Msg {

    //事件类型，subscribe(订阅)、unsubscribe(取消订阅)
    private String Event;
    //事件KEY值，为空
    private String EventKey;

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }
}
