package com.hopever.springexample.service;

import com.hopever.springexample.domain.User;
import com.hopever.springexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Donghui Huo on 2016/1/12.
 */
@Service
public class DatabaseUserService implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteOne(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.updateOne(user);
    }
}
