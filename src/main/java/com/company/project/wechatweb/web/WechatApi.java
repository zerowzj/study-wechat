package com.company.project.wechatweb.web;

import com.company.project.wechatweb.service.wechat.blogic.BLogic;
import com.company.project.wechatweb.service.wechat.msg.Msg;
import com.company.project.wechatweb.support.util.HttpServlets;
import com.company.project.wechatweb.support.util.XStreamUtil;
import com.company.project.wechatweb.support.wechat.msg.MsgParser;
import com.company.project.wechatweb.support.wechat.route.RouteFactory;
import com.company.project.wechatweb.support.wechat.route.RouteKeys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Wechat Api
 *
 * @author wangzhj
 */
@Controller
public class WechatApi implements ApplicationContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatApi.class);

    private static ApplicationContext cxt;

    @RequestMapping("/wechat/msg")
    public ResponseEntity<Void> dispatch(HttpServletRequest request) {
        try {
            //请求体
            String xmlBody = HttpServlets.getBodyString(request);
            LOGGER.info("{}", xmlBody);
            //xml ==> map
            Map<String, String> xmlMap = MsgParser.parse(xmlBody);
            //key ==> name ==> bean ==> target
            String key = RouteKeys.keyOfBean(xmlMap);
            String name = RouteFactory.getBeanName(key);
            BLogic bLogic = getBLogic(name);
            Class clazz = AopUtils.getTargetClass(bLogic);
            //执行业务
            Msg msg = XStreamUtil.fromXML(xmlBody, getMsgClazz(clazz));
            bLogic.doBusiness(msg);
        } catch (Exception ex) {
            throw ex;
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 获取消息BLogic
     */
    private <T> T getBLogic(String name) {
        if (!cxt.containsBean(name)) {
            throw new IllegalStateException("未包含[" + name + "]的Bean！");
        }
        return (T) cxt.getBean(name);
    }

    /**
     * 获取消息Class
     */
    private Class getMsgClazz(Class clazz) {
        if (clazz != null) {
            Type type = clazz.getGenericSuperclass();
            if (type instanceof ParameterizedType) {
                ParameterizedType ptype = ((ParameterizedType) type);
                Type[] args = ptype.getActualTypeArguments();
                clazz = (Class) args[0];
            }
        }
        return clazz;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        cxt = applicationContext;
    }
}
