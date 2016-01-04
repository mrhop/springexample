package com.hopever.springexample.repository;

import com.hopever.springexample.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Donghui Huo on 2016/1/4.
 */
@Repository
public class InMemoryUserRepository implements UserRepository {
    private final List<User> users = new ArrayList<User>();

    public InMemoryUserRepository() {
        this.users.add(new User(1, "Oliver", new Date()));
        this.users.add(new User(2, "Andy", new Date()));
        this.users.add(new User(3, "Dave", new Date()));
    }

    @Override
    public List<User> findAll() {
        return this.users;
    }

    @Override
    public User findOne(Integer id) {
        for (User user : this.users) {
            if (ObjectUtils.nullSafeEquals(user.getId(), id)) {
                return user;
            }
        }
        return null;
    }
}
