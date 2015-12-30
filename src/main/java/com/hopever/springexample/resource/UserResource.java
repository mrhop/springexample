package com.hopever.springexample.resource;

import org.springframework.hateoas.ResourceSupport;

import java.util.Date;

/**
 * Created by Donghui Huo on 2015/12/29.
 */
public class UserResource extends ResourceSupport {

    public String name;
    public Date birthday;
}
