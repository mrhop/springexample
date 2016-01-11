package com.hopever.springexample.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.core.Relation;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Donghui Huo on 2015/12/24.
 */
@Component
@Profile("test")
@Relation(value = "usr", collectionRelation = "usrList")
public class User {
    final static Logger logger = LoggerFactory.getLogger(User.class);

    public User() {
    }

    public User(Integer id,String name,Date date) {
        this.id =id;
        this.name = name;
        this.birthday = date;
    }

    public User(String name) {
        this.name = name;
    }

    private Integer id;

    @Value("${connection.name}")
    private String name;

    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    public String getName() {
       // logger.info("Begin prod getName......");
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
