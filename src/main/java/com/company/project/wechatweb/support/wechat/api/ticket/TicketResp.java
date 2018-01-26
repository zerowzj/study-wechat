package com.company.project.wechatweb.support.wechat.api.ticket;

import com.company.project.wechatweb.support.wechat.api.Resp;

/**
 * Ticket响应
 *
 * @author wangzhj
 */
public class TicketResp extends Resp {

    //Ticket
    private String ticket;
    //有效时间(秒)
    private int expires_in;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
