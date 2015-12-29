package com.hopever.springexample.web.rest;

import com.hopever.springexample.domain.Customer;
import com.hopever.springexample.domain.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Donghui Huo on 2015/12/25.
 */
@RestController
@RequestMapping(value="/rest")
public class MyRestController {
    @Resource
    private User user;

    @RequestMapping(value="/{name}/{birthday}", method= RequestMethod.GET)
    public User getUser( User user) {
        // ...
        return user;
    }

    @RequestMapping(value="/{user}/customers", method=RequestMethod.GET)
    List<Customer> getUserCustomers(@PathVariable String user) {
        // ...
        return new ArrayList<Customer>();
    }

    @RequestMapping(value="/{user}", method=RequestMethod.DELETE)
    public User deleteUser(@PathVariable String user) {
        // ...
        return this.user;
    }

}