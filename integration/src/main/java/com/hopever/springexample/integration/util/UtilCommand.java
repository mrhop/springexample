package com.hopever.springexample.integration.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by Donghui Huo on 2016/3/3.
 */
public class UtilCommand implements ApplicationContextAware {

    protected static Logger logger = LoggerFactory.getLogger(UtilCommand.class);
    protected ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
