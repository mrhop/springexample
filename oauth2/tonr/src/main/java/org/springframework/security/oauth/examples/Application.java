package org.springframework.security.oauth.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * Created by Donghui Huo on 2015/12/24.
 */
@SpringBootApplication
@EnableOAuth2Client
public class Application {
     public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}