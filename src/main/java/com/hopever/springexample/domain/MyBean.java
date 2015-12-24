package com.hopever.springexample.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by Donghui Huo on 2015/12/24.
 */
@Component
@Profile("proddb")
public class MyBean {

    @Value("${connection.name}")
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
