package com.hopever.springexample.db.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Created by huodh on 2/21/16.
 */
@Service
public class AmqpReceiver {
   @RabbitListener(queues = "test")
    public void processMessage(String content) {
        System.out.println(content);
    }
}
