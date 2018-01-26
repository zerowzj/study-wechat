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
import java.util.Arrays;
import java.util.Map;

/**
 * 有效性验证Filter
 *
 * @author wangzhj
 */
public class WechatValidFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatValidFilter.class);

    private static final String PARAM_SIGNATURE = "signature";

    private static final String PARAM_TIME_STAMP = "timestamp";

    private static final String PARAM_NONCE = "nonce";

    private static final String PARAM_ECHO_STR = "echostr";

    private static final String TOKEN = WechatCfg.getToken();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String method = request.getMethod().toUpperCase();
        if (Objects.equal("GET", method) && isValid(request)) {
            //有效性验证
            if (!isSignOk(request)) {
                LOGGER.info("签名验证未通过！");
                return;
            }
            LOGGER.info("签名验证通过！");
            HttpWrites.write(response, getEchostr(request));
        } else {
            //其他
            filterChain.doFilter(request, response);
        }
    }

    private boolean isValid(HttpServletRequest request) {
        Map<String, Object> params = request.getParameterMap();
        return params.containsKey(PARAM_SIGNATURE) && params.containsKey(PARAM_TIME_STAMP) &&
                params.containsKey(PARAM_NONCE) && params.containsKey(PARAM_ECHO_STR);
    }

    private boolean isSignOk(HttpServletRequest request) {
        //字典排序
        String[] src = {TOKEN, getTimestamp(request), getNonce(request)};
        Arrays.sort(src);
        //比较
        String mySrc = Joiner.on("").join(src);
        String mySign = DigestUtils.sha1Hex(mySrc);
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
