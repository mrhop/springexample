package com.hopever.springexample.integration.controlbus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;

/**
 * Created by Donghui Huo on 2016/3/2.
 */
//@Configuration
//@ImportResource("/META-INF/spring/integration/controlbus/controlbus-context.xml")
//@Order(3)
public class ControlBusCommand implements CommandLineRunner,ApplicationContextAware {
    private static Logger logger = LoggerFactory.getLogger(ControlBusCommand.class);
    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {
        MessageChannel controlChannel = applicationContext.getBean("controlChannel", MessageChannel.class);
        PollableChannel adapterOutputChanel = applicationContext.getBean("adapterOutputChanel", PollableChannel.class);
        logger.info("Received before adapter started: " + adapterOutputChanel.receive(1000));
        controlChannel.send(new GenericMessage<String>("@inboundAdapter.start()"));
        logger.info("Received before adapter started: " + adapterOutputChanel.receive(1000));
        controlChannel.send(new GenericMessage<String>("@inboundAdapter.stop()"));
        logger.info("Received after adapter stopped: " + adapterOutputChanel.receive(1000));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
