package com.hopever.springexample.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Donghui Huo on 2016/2/2.
 */
@Component
@Order(3)
public class MongoBean implements CommandLineRunner {

//    private final MongoTemplate mongoTemplate;
//
//    @Autowired
//    TestService testService;
//
//
//    @Autowired
//    public MongoBean(MongoTemplate mongoTemplate) {
//        this.mongoTemplate = mongoTemplate;
//    }

    @Override
    public void run(String... args) throws Exception {
        //System.out.println(testService.getUsersAll().iterator().next().getNickname());
       // System.out.println("mongodb init");
    }
}
