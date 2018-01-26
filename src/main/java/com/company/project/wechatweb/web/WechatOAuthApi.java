package com.company.project.wechatweb.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 微信Msg Api
 *
 * @author wangzhj
 */
@Deprecated
@Controller
public class WechatOAuthApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatOAuthApi.class);

    private static ApplicationContext cxt;

    @RequestMapping("/wechat/oauth")
    public void dispatch(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("");
        } catch (Exception ex) {
        }
    }
}
