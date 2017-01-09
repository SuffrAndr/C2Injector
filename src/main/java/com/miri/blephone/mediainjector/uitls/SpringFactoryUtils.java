package com.miri.blephone.mediainjector.uitls;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public final class SpringFactoryUtils implements ApplicationContextAware {

    private static SpringFactoryUtils instance;

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        SpringFactoryUtils.applicationContext = applicationContext;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(final String name) throws BeansException {
        return (T) SpringFactoryUtils.applicationContext.getBean(name);
    }

    public static SpringFactoryUtils getInstance() {

        if (SpringFactoryUtils.instance == null) {
            SpringFactoryUtils.instance = new SpringFactoryUtils();
        }

        return SpringFactoryUtils.instance;
    }
}
