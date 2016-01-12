package com.hopever.springexample.repository;

import com.hopever.springexample.domain.User;

import java.util.List;

/**
 * Created by Donghui Huo on 2016/1/4.
 */
public interface UserRepository {

    List<User> findAll();

    User findOne(Integer id);

    void deleteOne(Integer id);

    void updateOne(User user);
}
