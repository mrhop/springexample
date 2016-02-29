package com.hopever.springexample.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by huodh on 2/21/16.
 */
@Component
public class AmqpBean implements CommandLineRunner {
//    private final AmqpAdmin amqpAdmin;
//    private final AmqpTemplate amqpTemplate;
//    @Autowired
//    private AmqpSender amqpSender;
//
//
//    @Autowired
//    public AmqpBean(AmqpAdmin amqpAdmin, AmqpTemplate amqpTemplate) {
//        this.amqpAdmin = amqpAdmin;
//        this.amqpTemplate = amqpTemplate;
//    }


    @Override
    public void run(String... args) throws Exception {
       // amqpSender.processMessage("abcd");
    }
}
