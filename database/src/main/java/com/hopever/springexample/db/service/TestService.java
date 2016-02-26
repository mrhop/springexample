package com.hopever.springexample.db.service;

import com.hopever.springexample.db.jooq.h2.tables.pojos.Test;
import com.hopever.springexample.db.rdbs.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

import javax.transaction.TransactionManager;
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
//    @Autowired
//    private AmqpTemplate amqpTemplate;
//
//    @Autowired
//    private JmsMessagingTemplate jmsMessagingTemplate;

    //    @Transactional
//    public void trySend() throws Exception {
//        jmsMessagingTemplate.convertAndSend("testPeer", "hello queue world");
//        amqpTemplate.convertAndSend("test", "amqp value" + 1 / 0);
//        System.out.println("nothing send");
//    }
    @Autowired
    private TestRepository testRepository;
    @Autowired
    TransactionManager transactionManager;
    @Autowired
    PlatformTransactionManager platformTransactionManager;
    @Transactional
    public void tryRdbs() throws Exception {
        com.mysql.jdbc.jdbc2.optional.MysqlXADataSource a;
        Test test = new Test();
        //test.setId(1l);
        test.setName("you know 3");
        testRepository.save(test);
        test = new Test();
        test.setId(1l);
        test.setName("you know 4 JUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTIONJUST TRANSACTION");
        testRepository.save(test);
        System.out.println("JUST TRANSACTION");
    }

    @Transactional
    public Long tryGetRdbs() {
        return testRepository.count();
    }


}
