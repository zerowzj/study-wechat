package com.company.project.wechatweb.auth.filter;

import com.company.project.wechatweb.support.util.HttpWrites;
import com.company.project.wechatweb.support.util.WechatCfg;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 微信Filter
 *
 * @author wangzhj
 */
public class WechatFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatFilter.class);

    private static final String PARAM_SIGNATURE = "signature";

    private static final String PARAM_TIME_STAMP = "timestamp";

    private static final String PARAM_NONCE = "nonce";

    private static final String PARAM_ECHO_STR = "echostr";

    private static final String TOKEN;

    static {
        TOKEN = WechatCfg.getToken();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        //有效性验证
        String method = request.getMethod();
        if (Objects.equal("GET", method.toUpperCase()) && isValidity(request)) {
            if (isSignature(request)) {
                HttpWrites.write(response, getEchostr(request));
            } else {
                LOGGER.info("签名验证未通过");
            }
            return;
        }
        //继续执行
        filterChain.doFilter(request, response);
    }

    /**
     * 是否是验证
     */
    private boolean isValidity(HttpServletRequest request) {
        Map<String, Object> params = request.getParameterMap();
        return params.containsKey(PARAM_SIGNATURE) && params.containsKey(PARAM_TIME_STAMP) &&
                params.containsKey(PARAM_NONCE) && params.containsKey(PARAM_ECHO_STR);
    }

    /**
     * 验证签名
     */
    private boolean isSignature(HttpServletRequest request) {
        String src = Joiner.on("").join(TOKEN, getTimestamp(request), getNonce(request));
        String mySign = DigestUtils.sha1Hex(src);
        if (Objects.equal(mySign, getSignature(request))) {
            return true;
        }
        return false;
    }

    private String getSignature(HttpServletRequest request) {
        return request.getParameter(PARAM_SIGNATURE);
    }

    private String getTimestamp(HttpServletRequest request) {
        return request.getParameter(PARAM_TIME_STAMP);
    }

    private String getNonce(HttpServletRequest request) {
        return request.getParameter(PARAM_NONCE);
    }

    private String getEchostr(HttpServletRequest request) {
        return request.getParameter(PARAM_ECHO_STR);
    }
}
