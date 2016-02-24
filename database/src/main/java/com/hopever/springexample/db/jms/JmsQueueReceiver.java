package com.hopever.springexample.db.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.annotation.JmsListeners;
import org.springframework.stereotype.Service;

/**
 * Created by Donghui Huo on 2016/2/16.
 */
@Service
public class JmsQueueReceiver {
    @JmsListener(destination = "test1")
    @JmsListeners({@JmsListener(destination = "testPeer"),@JmsListener(destination = "testPub",subscription = "TestClient",containerFactory = "jmsListenerContainerPubSubFactory")})
    public void receiveQueue(String text){
        System.out.println(text);
    }

}
