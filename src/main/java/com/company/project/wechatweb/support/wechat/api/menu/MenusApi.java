package com.company.project.wechatweb.support.wechat.api.menu;

import com.company.project.wechatweb.common.parser.MenuParser;
import com.company.project.wechatweb.wechat.token.Tokens;
import com.github.kevinsawicki.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 微信菜单
 *
 * @author wangzhj
 */
public class MenusApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(MenusApi.class);

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
        url.append(Tokens.getAccessToken());
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
