package com.hopever.springexample.db.service;

import com.hopever.springexample.db.mongodb.Users;
import com.hopever.springexample.db.mongodb.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by huodh on 2/13/16.
 */
@Service
public class TestService {
    @Autowired
    UsersRepository repository;

    @Cacheable("default")
    public Iterable<Users> getUsersAll(){
        return repository.findAll();
    }
}
