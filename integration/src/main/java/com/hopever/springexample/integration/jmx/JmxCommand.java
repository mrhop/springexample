package com.hopever.springexample.integration.jmx;

import com.hopever.springexample.integration.util.UtilCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;

/**
 * Created by Donghui Huo on 2016/3/4.
 */
@Configuration
@Order(11)
@ImportResource("/META-INF/spring/integration/jmx/jmx-config.xml")
public class JmxCommand extends UtilCommand implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
//        Thread.sleep(20000);
    }
}
