package com.hopever.springexample.integration.quote;

import com.hopever.springexample.integration.util.UtilCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;

/**
 * Created by Donghui Huo on 2016/3/8.
 */
@Configuration
@Order(17)
@ImportResource("/META-INF/spring/integration/quote/quote-config.xml")
public class QuoteCommand extends UtilCommand implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

    }
}
