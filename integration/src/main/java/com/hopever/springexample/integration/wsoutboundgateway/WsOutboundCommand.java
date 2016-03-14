package com.hopever.springexample.integration.wsoutboundgateway;

import com.hopever.springexample.integration.util.UtilCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.support.channel.BeanFactoryChannelResolver;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.core.DestinationResolver;

/**
 * Created by Donghui Huo on 2016/3/14.
 */
//@Configuration
//@Order(25)
//@ImportResource("META-INF/spring/integration/ws-outbound-gateway/temperatureConversion.xml")
public class WsOutboundCommand extends UtilCommand implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        String requestXml =
                "<FahrenheitToCelsius xmlns=\"http://www.w3schools.com/xml/\">" +
                        "<Fahrenheit>90.0</Fahrenheit>" +
                        "</FahrenheitToCelsius>";
        DestinationResolver<MessageChannel> channelResolver = new BeanFactoryChannelResolver(applicationContext);

        Message<String> message = MessageBuilder.withPayload(requestXml).build();
        MessageChannel channel = channelResolver.resolveDestination("fahrenheitChannel");
        channel.send(message);
    }
}
