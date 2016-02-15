package com.hopever.springexample.db.service;

import com.hopever.springexample.db.mongodb.Users;
import com.hopever.springexample.db.mongodb.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Iterable<Users> getUsersAll(){
        return repository.findAll();
    }
}
