package com.hopever.springexample.db.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by Donghui Huo on 2016/2/16.
 */
@Service
public class JmsQueueSender {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMsg(){
        jmsMessagingTemplate.getJmsTemplate().setPubSubDomain(false);
        jmsMessagingTemplate.convertAndSend("test1","hello topic world");
        jmsMessagingTemplate.getJmsTemplate().setPubSubDomain(true);
        jmsMessagingTemplate.convertAndSend("Test","hello topic world");
    }

}
