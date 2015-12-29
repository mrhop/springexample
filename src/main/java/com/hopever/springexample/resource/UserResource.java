package com.hopever.springexample.resource;

import com.hopever.springexample.domain.User;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Donghui Huo on 2015/12/29.
 */
public class UserResource extends ResourceSupport {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
