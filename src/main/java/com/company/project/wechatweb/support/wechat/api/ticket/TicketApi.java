package com.company.project.wechatweb.support.wechat.api.ticket;

import com.company.project.wechatweb.support.util.JsonUtil;
import com.company.project.wechatweb.support.wechat.api.token.TokenApi;
import com.github.kevinsawicki.http.HttpRequest;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Ticket Api
 *
 * @author wangzhj
 */
public class TicketApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(TicketApi.class);

    private static final String URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";

    private static String TYPE = "jsapi";

    private static String ticket;

    private static long overTimeMillis = -1;

    /**
     * 获取Ticket
     *
     * @return String
     */
    public synchronized static String getTicket() {
        long now = System.currentTimeMillis();
        if (overTimeMillis <= now) {
            doGet();
        }
        if (Strings.isNullOrEmpty(ticket)) {
            throw new IllegalStateException("未获取到[ticket]");
        }
        return ticket;
    }

    private synchronized static void doGet() {
        //参数
        Map<String, String> params = Maps.newHashMap();
        params.put("access_token", TokenApi.getAccessToken());
        params.put("type", TYPE);
        //请求
        LOGGER.info("获取ticket==>{}", JsonUtil.toJson(params));
        HttpRequest request = HttpRequest.get(URL, params, false);
        //响应
        LOGGER.info("status code={}", request.code());
        TicketResp ticketResp = null;
        if (request.ok()) {
            String body = request.body();
            LOGGER.info("获取ticket<=={}", body);
            ticketResp = JsonUtil.fromJson(body, TicketResp.class);
        }
        if (ticketResp != null && ticketResp.ok()) {
            overTimeMillis = System.currentTimeMillis() + ticketResp.getExpires_in() * 1000;
            ticket = ticketResp.getTicket();
        }
    }

    public static void main(String[] args) {
        getTicket();
    }
}
