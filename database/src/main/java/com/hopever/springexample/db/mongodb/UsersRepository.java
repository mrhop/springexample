package com.hopever.springexample.db.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;

/**
 * Created by Donghui Huo on 2016/2/2.
 */
public interface UsersRepository extends MongoRepository<Users, Serializable> {

}
