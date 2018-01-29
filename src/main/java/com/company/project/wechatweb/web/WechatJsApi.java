package com.company.project.wechatweb.web;

import com.company.project.wechatweb.support.wechat.api.ticket.TicketApi;
import com.company.project.wechatweb.support.wechat.config.WechatCfg;
import com.company.project.wechatweb.support.wechat.config.WechatJsParams;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 微信Js Api
 *
 * @author wangzhj
 */
@RestController
@RequestMapping("/wechatjs/")
public class WechatJsApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatJsApi.class);

    /**
     * 获取配置信息
     *
     * @param request
     * @return Map<String ,       String>
     */
    @RequestMapping("/getConfig")
    public Map<String, String> getConfig(HttpServletRequest request) {
        //获取参数
        String url = request.getParameter("url");
        if (Strings.isNullOrEmpty(url)) {
            throw new IllegalStateException("");
        }
        //计算签名
        Map<String, String> data = Maps.newTreeMap();
        data.put("jsApiTicket", TicketApi.getTicket());
        data.put("nonceStr", WechatJsParams.createNonceStr());
        data.put("timestamp", WechatJsParams.createTimestamp());
        data.put("url", url);
        String src = Joiner.on("&").withKeyValueSeparator("=").join(data);
        String sign = DigestUtils.sha1Hex(src);
        //其他参数
        data.put("signature", sign);
        data.put("appId", WechatCfg.getAppId());

        return data;
    }
}
