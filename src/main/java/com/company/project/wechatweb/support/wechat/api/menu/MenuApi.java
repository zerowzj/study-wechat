package com.company.project.wechatweb.support.wechat.api.menu;

import com.company.project.wechatweb.support.wechat.api.token.TokenApi;
import com.company.project.wechatweb.support.wechat.menu.MenuParser;
import com.github.kevinsawicki.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 菜单Api
 *
 * @author wangzhj
 */
public class MenuApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(MenuApi.class);

    private static final String URL = "https://api.weixin.qq.com/cgi-bin/menu/create";

    /**
     * 初始化菜单
     *
     * @param json
     */
    public static void initMenu(String json) {
        LOGGER.info("初始化菜单===>{}", json);
        //生成url
        StringBuffer url = new StringBuffer(URL);
        url.append("?access_token=");
        url.append(TokenApi.getAccessToken());
        //
        HttpRequest request = HttpRequest.post(url.toString()).send(json);
        if (request.ok()) {
            String body = request.body();
            LOGGER.info("初始化菜单<==={}", body);
        }
    }

    public static void main(String[] args) {
        initMenu(MenuParser.getMenu());
    }
}
