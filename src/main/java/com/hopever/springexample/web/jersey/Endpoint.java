package com.hopever.springexample.web.jersey;

import com.hopever.springexample.domain.User;
import com.hopever.springexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Donghui Huo on 2016/1/4.
 */
@Component
@Path("/user")
public class Endpoint {
    @Autowired
    private UserRepository userRepository;

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public User message() {
        return userRepository.findOne(1);
    }

}
