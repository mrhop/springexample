package com.hopever.springexample.service;

import com.hopever.springexample.domain.User;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

/**
 * Created by Donghui Huo on 2016/1/12.
 */
public interface UserService {

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    public List<User> getUsers();

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    public User getUser(Integer id);

    @Secured("ROLE_ADMIN")
    public void deleteUser(Integer id);

    @Secured("ROLE_USER")
    public void updateUser(User user);


}
