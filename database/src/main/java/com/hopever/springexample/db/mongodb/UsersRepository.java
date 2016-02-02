package com.hopever.springexample.db.mongodb;

import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

/**
 * Created by Donghui Huo on 2016/2/2.
 */
public interface UsersRepository extends CrudRepository<Users, Serializable> {

}
