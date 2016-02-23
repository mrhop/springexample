package com.hopever.springexample.db.mongodb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.transaction.PseudoTransactionManager;

/**
 * Created by huodh on 2/23/16.
 */
@Configuration
public class MongoConfig {
    @Bean
    public PseudoTransactionManager pseudoTransactionManager(){
        return new TestMongoTransactionManager();
    }
}
