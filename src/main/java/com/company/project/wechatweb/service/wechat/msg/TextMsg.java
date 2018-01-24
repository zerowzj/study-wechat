package com.company.project.wechatweb.service.wechat.msg;

/**
 * 文本消息
 *
 * @author wangzhj
 */
public class TextMsg extends Msg {

    //消息id，64位整型
    private String MsgId;

    //文本消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }
}
