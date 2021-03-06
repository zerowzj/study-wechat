package com.company.project.wechatweb.support.wechat.api.menu;

import com.company.project.wechatweb.support.wechat.api.token.TokenApi;
import com.github.kevinsawicki.http.HttpRequest;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

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
        LOGGER.info("create menu===>{}", json);
        //URL
        StringBuffer myUrl = new StringBuffer(CREATE_URL);
        myUrl.append("?access_token=")
                .append(TokenApi.getAccessToken());
        //请求
        HttpRequest request = HttpRequest.post(myUrl).send(json);
        //响应
        if (request.ok()) {
            String body = request.body();
            LOGGER.info("create menu<==={}", body);
        }
    }

    /**
     * 获取菜单
     */
    public static void getMenu() {
        LOGGER.info("get menu===>{}");
        //参数
        Map<String, String> params = Maps.newHashMap();
        params.put("access_token", TokenApi.getAccessToken());
        //请求
        HttpRequest request = HttpRequest.post(GET_URL, params, false);
        //响应
        if (request.ok()) {
            String body = request.body();
            LOGGER.info("get menu<==={}", body);
        }
    }

    public static void main(String[] args) {
//        createMenu(MenuParser.getMenu());
        getMenu();
    }
}
