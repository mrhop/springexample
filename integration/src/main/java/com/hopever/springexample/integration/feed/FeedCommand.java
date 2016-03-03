package com.hopever.springexample.integration.feed;

import com.hopever.springexample.integration.util.UtilCommand;
import com.rometools.rome.feed.synd.SyndEntry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;

/**
 * Created by Donghui Huo on 2016/3/3.
 */
@Configuration
@Order(5)
@ImportResource("/META-INF/spring/integration/feed/feed-context.xml")
public class FeedCommand extends UtilCommand implements CommandLineRunner {

    @Override
    @SuppressWarnings("unchecked")
    public void run(String... args) throws Exception {
        PollableChannel feedChannel = applicationContext.getBean("feedChannel", PollableChannel.class);
        for (int i = 0; i < 10; i++) {
            Message<SyndEntry> message = (Message<SyndEntry>) feedChannel.receive(1000);
            if (message != null){
                SyndEntry entry = message.getPayload();
                System.out.println(entry.getPublishedDate() + " - " + entry.getTitle());
            }
            else {
                break;
            }
        }
    }
}
