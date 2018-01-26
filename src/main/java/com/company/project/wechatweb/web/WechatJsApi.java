package com.company.project.wechatweb.web;

import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class WechatJsApi {

    @RequestMapping("/getJsSign")
    public Map<String, String> getJsSign(HttpServletRequest request) {
        Map<String, String> data = Maps.newHashMap();
        return data;
    }
}
