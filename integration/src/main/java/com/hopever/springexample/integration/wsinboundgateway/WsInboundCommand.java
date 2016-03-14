package com.hopever.springexample.integration.wsinboundgateway;

import com.hopever.springexample.integration.util.UtilCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

/**
 * Created by Donghui Huo on 2016/3/14.
 */
//@Configuration
//@Order(24)
//@ImportResource("META-INF/spring/integration/ws-inbound-gateway/inbound-gateway-config.xml")
public class WsInboundCommand extends UtilCommand implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

    }

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/echoservice");
    }

}
