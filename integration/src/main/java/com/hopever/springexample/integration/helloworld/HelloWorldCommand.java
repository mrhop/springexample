package com.hopever.springexample.integration.helloworld;

import com.hopever.springexample.integration.util.UtilCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;

/**
 * Created by Donghui Huo on 2016/3/3.
 */
//@Configuration
//@Order(8)
//@ImportResource("/META-INF/spring/integration/helloworld/helloworld-context.xml")
public class HelloWorldCommand extends UtilCommand implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        MessageChannel inputChannel = applicationContext.getBean("inputChannel", MessageChannel.class);
        PollableChannel outputChannel = applicationContext.getBean("outputChannel", PollableChannel.class);
        inputChannel.send(new GenericMessage<String>("World"));
        logger.info("==> HelloWorldDemo: " + outputChannel.receive(0).getPayload());

    }
}
