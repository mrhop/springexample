package com.hopever.springexample.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Donghui Huo on 2016/2/16.
 */
@Component
@Order(1)
public class JmsBean implements CommandLineRunner {
//    @Autowired
//    JmsQueueSender jmsQueueSender;
//    @Autowired
//    JmsTemplate jmsTemplate;

    @Override
    public void run(String... args) throws Exception {
//        jmsQueueSender.sendMsg();
    }
}
