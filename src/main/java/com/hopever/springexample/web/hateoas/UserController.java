package com.hopever.springexample.web.hateoas;

import com.hopever.springexample.domain.User;
import com.hopever.springexample.resource.UserResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by Donghui Huo on 2015/12/29.
 */
@Controller
@RequestMapping("/user/hateoas")
public class UserController {

    @Value("${myhost.domain}")
    private String host;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public HttpEntity<UserResource> showAll() {
        User u= new User();
        u.setBirthday(new Date());
        u.setName("you know");
        UserResource ur = new UserResource();
        ur.setUser(u);
        ur.add(new Link("http://"+host+"/people"));
        return new ResponseEntity<UserResource>(ur, HttpStatus.OK);
    }
    @RequestMapping(path="/json",method = RequestMethod.GET)
    @ResponseBody
    public UserResource showAllWithJson() {
        User u= new User();
        u.setBirthday(new Date());
        u.setName("you know");
        UserResource ur = new UserResource();
        ur.setUser(u);
        ur.add(new Link("http://"+host+"/people"));
        return ur;
    }


}
