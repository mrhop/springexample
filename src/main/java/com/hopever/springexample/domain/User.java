package com.hopever.springexample.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Donghui Huo on 2015/12/24.
 */
@Component
@Profile("prod")
public class User {
    final static Logger logger = LoggerFactory.getLogger(User.class);

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    @Value("${connection.name}")
    private String name;

    private Date birthday;

    public String getName() {
        logger.info("Begin prod getName......");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
