package com.company.project.wechatweb.web;

import com.company.project.wechatweb.support.wechat.config.WechatCfg;
import com.company.project.wechatweb.support.wechat.config.WechatJsCfg;
import com.google.common.collect.Maps;
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

    /**
     * 获取
     */
    @RequestMapping("/getConfig")
    public Map<String, String> getConfig(HttpServletRequest request) {
        Map<String, String> data = Maps.newHashMap();
        data.put("appId", WechatCfg.getAppId());
        data.put("timestamp", WechatJsCfg.createTimestamp());
        data.put("nonceStr", WechatJsCfg.createNonceStr());
        data.put("signature", "");
        return data;
    }
}
