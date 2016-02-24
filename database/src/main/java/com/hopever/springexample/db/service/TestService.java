package com.hopever.springexample.db.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by huodh on 2/13/16.
 */
@Service
public class TestService {
//    @Autowired
//    UsersRepository repository;
//    //@Cacheable("need")
//    @CacheResult(cacheName="need")
//   // @Transactional(transactionManager = "pseudoTransactionManager")
//    public Iterable<Users> getUsersAll() throws Exception{
////        Users u = new Users();
////        u.setNickname("123");
////        u.setUsername("bbb");
////        repository.save(u);
////        int a = 1/0;
//        return repository.findAll();
//    }

    //test two transactions
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Transactional
    public void trySend() throws Exception {
        jmsMessagingTemplate.convertAndSend("testPeer", "hello queue world");
        amqpTemplate.convertAndSend("test", "amqp value" + 1 / 0);
        System.out.println("nothing send");
    }

}
