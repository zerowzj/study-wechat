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
     * @return Map<String                                                                                                                                                                                                                                                               ,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               String>
     */
    @RequestMapping("/getConfig")
    public Map<String, String> getConfig(HttpServletRequest request) {
        //获取参数
        String url = request.getParameter("url");
        if (Strings.isNullOrEmpty(url)) {
            throw new IllegalStateException("");
        }
        //计算签名
        Map<String, String> srcData = Maps.newTreeMap();
        srcData.put("jsapi_ticket", TicketApi.getTicket());
        String nonceStr = WechatJsParams.createNonceStr();
        srcData.put("noncestr", nonceStr);
        String timestamp = WechatJsParams.createTimestamp();
        srcData.put("timestamp", timestamp);
        srcData.put("url", url);
        String src = Joiner.on("&").withKeyValueSeparator("=").join(srcData);
        String sign = DigestUtils.sha1Hex(src);
        //
        Map<String, String> data = Maps.newTreeMap();
        data.put("appId", WechatCfg.getAppId());
        data.put("nonceStr", nonceStr);
        data.put("timestamp", timestamp);
        data.put("signature", sign);

        return data;
    }
}
