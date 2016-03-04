package com.hopever.springexample.integration.http;

import com.hopever.springexample.integration.util.UtilCommand;
import org.springframework.boot.CommandLineRunner;

/**
 * Created by Donghui Huo on 2016/3/3.
 */
//@Configuration
//@Order(9)
//@ImportResource({"/META-INF/spring/integration/http/servlet-config.xml","/META-INF/spring/integration/http/http-outbound-config.xml"})
public class httpCommand extends UtilCommand implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        //still need a servlet for dispatcher
        RequestGateway requestGateway = applicationContext.getBean("requestGateway", RequestGateway.class);
        String reply = requestGateway.echo("Hello");
        logger.info("\n\n++++++++++++ Replied with: " + reply + " ++++++++++++\n");
    }
}
