package com.company.project.wechatweb.support;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Spring 上下文
 *
 * @author wangzhj
 */
public class SpringContext implements ApplicationContextAware {

    private static ApplicationContext CXT;

    /**
     * 获取
     *
     * @param name
     * @return T
     */
    public static <T> T getBean(String name) {
        return (T) CXT.getBean(name);
    }

    /**
     * 获取
     *
     * @param name
     * @return boolean
     */
    public static boolean containBean(String name) {
        return CXT.containsBean(name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.CXT = applicationContext;
    }
}
