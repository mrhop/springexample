package com.hopever.springexample.integration.websockets;

import com.hopever.springexample.integration.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.*;
/**
 * Created by Donghui Huo on 2016/3/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0", "management.port=0"})
public class ApplicationTests  {
    @Value("${local.server.port}")
    private String port;

    @Test
    public void testWebSockets() throws InterruptedException {
        System.setProperty("local.server.port", this.port);
        ConfigurableApplicationContext client
                = new ClassPathXmlApplicationContext("/META-INF/spring/integration/web-sockets/client-context.xml");
        DirectChannel webSocketInputChannel = client.getBean("webSocketInputChannel", DirectChannel.class);

        final CountDownLatch stopLatch = new CountDownLatch(2);

        webSocketInputChannel.addInterceptor(new ChannelInterceptorAdapter() {
            @Override
            public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
                Object payload = message.getPayload();
                System.out.println("you know:"+payload);
                assertThat(payload, instanceOf(String.class));
                Date date = null;
                try {
                    date = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.DEFAULT).parse((String) payload);
                }
                catch (ParseException e) {
                    fail("fail to parse date");
                }
                assertThat(new Date().compareTo(date), greaterThanOrEqualTo(0));
                stopLatch.countDown();
            }

        });
        assertTrue(stopLatch.await(10, TimeUnit.SECONDS));
        client.close();
    }
}
