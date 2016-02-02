package com.hopever.springexample.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Donghui Huo on 2015/12/24.
 */
@SpringBootApplication
@EnableJpaRepositories
public class Application {
     public static void main(String[] args) {
         SpringApplication.run(Application.class, args);
    }
}