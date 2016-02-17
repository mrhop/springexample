package com.hopever.springexample.db.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQProperties;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by Donghui Huo on 2016/2/16.
 */
@Service
public class JmsQueueSender {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private JmsMessagingTemplate jmsMessagingPubSubTemplate;
    public void sendMsg(){
        ActiveMQProperties a;
        jmsMessagingTemplate.convertAndSend("testPeer","hello queue world");
        jmsMessagingPubSubTemplate.convertAndSend("testPub","hello topic world");
    }

}