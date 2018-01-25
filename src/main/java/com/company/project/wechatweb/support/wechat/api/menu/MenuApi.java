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

    private static final String CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create";

    private static final String GET_URL = "https://api.weixin.qq.com/cgi-bin/menu/get";

    /**
     * 创建菜单
     *
     * @param json
     */
    public static void createMenu(String json) {
        LOGGER.info("创建菜单===>{}", json);
        //生成URL
        StringBuffer url = new StringBuffer(CREATE_URL);
        url.append("?access_token=");
        url.append(TokenApi.getAccessToken());
        //
        HttpRequest request = HttpRequest.post(url.toString()).send(json);
        if (request.ok()) {
            String body = request.body();
            LOGGER.info("创建菜单<==={}", body);
        }
    }

    /**
     * 获取菜单
     */
    public static void getMenu() {
        LOGGER.info("获取菜单===>{}");
        //生成URL
        StringBuffer url = new StringBuffer(GET_URL);
        url.append("?access_token=");
        url.append(TokenApi.getAccessToken());
        //
        HttpRequest request = HttpRequest.post(url.toString());
        if (request.ok()) {
            String body = request.body();
            LOGGER.info("获取菜单<==={}", body);
        }
    }

    public static void main(String[] args) {
        createMenu(MenuParser.getMenu());
//        getMenu();
    }
}
