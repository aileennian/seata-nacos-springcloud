package com.syx.nian.demo.ali.core.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    private static void checkForInitialized() {
        if (applicationContext == null) {
            synchronized (SpringUtils.class) {
                if (applicationContext == null) {
                    try {
                        SpringUtils.class.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }


    @SuppressWarnings("unchecked")
    public static <T> T bean(String name) {
        checkForInitialized();
        return (T) applicationContext.getBean(name);
    }

    public static <T> T bean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    public static <T> T bean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
    }
}
