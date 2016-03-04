package com.hopever.springexample.integration.jms;

import com.hopever.springexample.integration.util.UtilCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

/**
 * Created by Donghui Huo on 2016/3/4.
 */
@Configuration
@Order(10)
@ImportResource({"/META-INF/spring/integration/jms/common.xml","/META-INF/spring/integration/jms/inboundGateway.xml","/META-INF/spring/integration/jms/outboundGateway.xml"})
public class JmsCommandGateway extends UtilCommand implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.setProperty("spring.profiles.active", "testCase");

        final MessageChannel stdinToJmsoutChannel = applicationContext.getBean("stdinToJmsoutChannel", MessageChannel.class);

        stdinToJmsoutChannel.send(MessageBuilder.withPayload("jms test").build());

        final QueueChannel queueChannel = applicationContext.getBean("queueChannel", QueueChannel.class);

        @SuppressWarnings("unchecked")
        Message<String> reply = (Message<String>) queueChannel.receive(20000);
        String out = reply.getPayload();
        logger.info("jms test", out);

    }
}
