package com.hopever.springexample.integration.xmpp;

import com.hopever.springexample.integration.util.UtilCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

/**
 * Created by Donghui Huo on 2016/3/14.
 */
@Configuration
@Order(27)
//@ImportResource("META-INF/spring/integration/xmpp/ReceiveInstantMessageSample-context.xml")
@ImportResource("META-INF/spring/integration/xmpp/SendInstantMessageSample-context.xml")
public class XmppCommand extends UtilCommand implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        //Thread.sleep(20000*10);

        //SEND
        MessageChannel toUserChannel = applicationContext.getBean("toUserChannel", MessageChannel.class);
        Message<String> message = new GenericMessage<String>("Hello from Spring Integration XMPP");
        toUserChannel.send(message);
    }
}
