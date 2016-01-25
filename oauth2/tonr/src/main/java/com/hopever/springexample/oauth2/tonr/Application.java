package com.hopever.springexample.oauth2.tonr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Donghui Huo on 2015/12/24.
 */
@SpringBootApplication
public class Application {
     public static void main(String[] args) {
         org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer a;
        SpringApplication.run(Application.class, args);
    }
}