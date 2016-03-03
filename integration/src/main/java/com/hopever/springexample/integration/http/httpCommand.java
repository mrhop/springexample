package com.hopever.springexample.integration.http;

import com.hopever.springexample.integration.util.UtilCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;

/**
 * Created by Donghui Huo on 2016/3/3.
 */
@Configuration
@Order(9)
@ImportResource("/META-INF/spring/integration/http/servlet-config.xml")
public class httpCommand extends UtilCommand implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        //still need a servlet for dispatcher
    }
}
