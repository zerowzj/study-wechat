package com.company.project.wechatweb.auth.filter;

import com.company.project.wechatweb.auth.OpenIds;
import com.company.project.wechatweb.support.wechat.api.token.AuthTokenApi;
import com.company.project.wechatweb.support.wechat.api.token.AuthTokenResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 授权Filter
 *
 * @author wangzhj
 */
public class WechatAuthFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatAuthFilter.class);

    private static final String PARAM_CODE = "code";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        LOGGER.info("url==>{}", request.getRequestURI());
        LOGGER.info("query string==>{}", request.getQueryString());
        try {
            //获取OpenId
            String code = getCode(request);
            LOGGER.info("code={}", code);
            AuthTokenResp token = AuthTokenApi.getAccessToken(code);
            String openId = token.getOpenid();
            OpenIds.set(openId);
            //继续执行
            filterChain.doFilter(request, response);
        } finally {
            OpenIds.remove();
        }
    }

    private String getCode(HttpServletRequest request) {
        return request.getParameter(PARAM_CODE);
    }

}
