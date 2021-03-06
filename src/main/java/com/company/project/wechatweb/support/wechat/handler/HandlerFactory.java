package com.company.project.wechatweb.support.wechat.handler;

import com.company.project.wechatweb.support.util.Dom4jUtil;
import com.google.common.collect.Maps;
import org.dom4j.Document;
import org.dom4j.Element;

import java.util.List;
import java.util.Map;

/**
 * 微信Msg Handler Factory
 *
 * @author wangzhj
 */
public class HandlerFactory {

    //命名空间
    private static final String XPATH_NAME_SPACE_URL = "http://www.company.cn/handlers";
    //XPath
    private static final String XPATH_ROUTE = "/xmlns:handlers/xmlns:handler";

    private static final String FILE = "wechat/handler-config.xml";

    private static final Map<String, String> BEAN_MAP = Maps.newHashMap();

    static {
        Document doc = Dom4jUtil.getDoc(FILE, XPATH_NAME_SPACE_URL);
        List<Element> eleLt = doc.selectNodes(XPATH_ROUTE);
        parse(eleLt);
    }

    private static void parse(List<Element> eleLt) {
        for (Element ele : eleLt) {
            String msgType = Dom4jUtil.attrValue(ele, "msgType");
            String event = Dom4jUtil.attrValue(ele, "event");
            String eventKey = Dom4jUtil.attrValue(ele, "eventKey");

            String key = HandlerKeys.keyOfHandler(msgType, event, eventKey);
            String bean = Dom4jUtil.attrValue(ele, "bean");

            BEAN_MAP.put(key, bean);
        }
    }

    /**
     * 获取Bean Name
     *
     * @param key
     * @return String
     */
    public static String getBeanName(String key) {
        return BEAN_MAP.get(key);
    }
}
