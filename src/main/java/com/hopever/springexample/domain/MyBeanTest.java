package com.hopever.springexample.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by Donghui Huo on 2015/12/24.
 */
@Component
@Profile("test1")
public class MyBeanTest extends MyBean {

    @Value("${name1}")
    private String name;

    public String getName(){
        logger.info("Begin test getName......");
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
