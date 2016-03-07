package com.hopever.springexample.integration.mail;

import com.hopever.springexample.integration.util.UtilCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

/**
 * Created by Donghui Huo on 2016/3/7.
 */
@Configuration
@Order(14)
@ImportResource("/META-INF/spring/integration/mail/mail-config.xml")
public class MailCommand extends UtilCommand implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        DirectChannel inputChannel = applicationContext.getBean("receiveChannel", DirectChannel.class);
        inputChannel.subscribe(new MessageHandler() {
            public void handleMessage(Message<?> message) throws MessagingException {
                logger.info("Message: " + message);
            }
        });
    }
}
