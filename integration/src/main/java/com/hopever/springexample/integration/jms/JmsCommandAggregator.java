package com.hopever.springexample.integration.jms;

import com.hopever.springexample.integration.util.UtilCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.util.List;

/**
 * Created by Donghui Huo on 2016/3/4.
 */
//@Configuration
//@Order(10)
//@ImportResource({"/META-INF/spring/integration/jms/common.xml","/META-INF/spring/integration/jms/aggregation.xml"})
public class JmsCommandAggregator extends UtilCommand implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        final MessageChannel stdinToJmsoutChannel = applicationContext.getBean("stdinToJmsoutChannel", MessageChannel.class);

        stdinToJmsoutChannel.send(MessageBuilder.withPayload("jms test").build());

        final QueueChannel queueChannel = applicationContext.getBean("queueChannel", QueueChannel.class);

        @SuppressWarnings("unchecked")
        Message<List<String>> reply = (Message<List<String>>) queueChannel.receive(20000);
        List<String> out = reply.getPayload();
        logger.info("jms test"+out.toString());
    }
}
