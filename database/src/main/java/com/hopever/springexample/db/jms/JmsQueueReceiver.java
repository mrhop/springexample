package com.hopever.springexample.db.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Donghui Huo on 2016/2/16.
 */
@Service
public class JmsQueueReceiver {
    @Autowired
    private JmsListenerContainerFactory jmsListenerContainerFactory;

    @JmsListener(destination = "test1")
    //@JmsListeners(@JmsListener(destination = "test1"))
    //now the factory ,pubsub and p-p schema
    public void receiveQueue(String text){
        System.out.println(text);
    }

}
