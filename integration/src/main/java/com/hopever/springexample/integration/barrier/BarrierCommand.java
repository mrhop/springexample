package com.hopever.springexample.integration.barrier;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by Donghui Huo on 2016/3/1.
 */
//@Configuration
//@ImportResource("/META-INF/spring/integration/barrier/server-context.xml")
//@Order(2)
public class BarrierCommand  implements CommandLineRunner,ApplicationContextAware{

    private  ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {

        CachingConnectionFactory connectionFactory =  applicationContext.getBean(CachingConnectionFactory.class);
        connectionFactory.setPublisherConfirms(true);
        connectionFactory.resetConnection();

        applicationContext.getBean("barrier.handler");
        ConfigurableApplicationContext client
                = new SpringApplicationBuilder("/META-INF/spring/integration/barrier/client-context.xml")
                .web(false)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
        RequestGateway requestGateway = client.getBean("requestGateway", RequestGateway.class);
        String request = "A,B,C";
        System.out.println("\n\n++++++++++++ Sending: " + request + " ++++++++++++\n");
        String reply = requestGateway.echo(request);
        System.out.println("\n\n++++++++++++ Replied with: " + reply + " ++++++++++++\n");
        client.close();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
