package com.hopever.springexample.db.service;

import com.hopever.springexample.db.mongodb.Users;
import com.hopever.springexample.db.mongodb.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.cache.annotation.CacheResult;

/**
 * Created by huodh on 2/13/16.
 */
@Service
public class TestService {
    @Autowired
    UsersRepository repository;
    //@Cacheable("need")
    @CacheResult(cacheName="need")
    @Transactional(transactionManager = "pseudoTransactionManager")
    public Iterable<Users> getUsersAll(){
        Users u = new Users();
        u.setNickname("123");
        u.setUsername("bbb");
        repository.save(u);
        return repository.findAll();
    }
}
