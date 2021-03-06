package com.hopever.springexample.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by Donghui Huo on 2015/12/24.
 */
@Component
@Profile("test1")
public class Customer {
    final static Logger logger = LoggerFactory.getLogger(Customer.class);

    @Value("${connection.name}")
    private String name;

    public String getName(){
        logger.info("Begin test getName......");
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
