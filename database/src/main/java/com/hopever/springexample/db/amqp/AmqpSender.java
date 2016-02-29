package com.hopever.springexample.db.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by huodh on 2/21/16.
 */
//@Service
public class AmqpSender {

//    @Autowired
//    private AmqpTemplate amqpTemplate;

//    @Transactional
    public void processMessage(String content) {
        // ...
//        ActiveMQProperties a;
//        RabbitResourceHolder rabbitResourceHolder;
//        amqpTemplate.convertAndSend("test",content);
//        amqpTemplate.convertAndSend("test",content+1);
    }
}
