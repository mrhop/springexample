package com.hopever.springexample;

import com.hopever.springexample.domain.MyBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Donghui Huo on 2015/12/24.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@Controller
public class Application {

    @Resource
    private MyBean myBean;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!"+myBean.getName();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}