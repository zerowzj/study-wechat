package com.company.project.wechatweb.service.wechat.msg;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 菜单事件消息
 *
 * @author wangzhj
 */
@XStreamAlias("xml")
public class MenuMsg extends Msg {

    //事件类型，CLICK、VIEW
    private String Event;
    //事件KEY值，CLICK时与自定义菜单接口中KEY值对应，VIEW时设置的跳转URL
    private String EventKey;

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }
}
