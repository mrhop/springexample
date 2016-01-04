package com.hopever.springexample.resource;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import java.util.Date;

/**
 * Created by Donghui Huo on 2015/12/29.
 */
@Relation(value = "user", collectionRelation = "users")
public class UserResource extends ResourceSupport {
    public UserResource(){}
    public UserResource(String name,Date birthday){
        this.name = name;
        this.birthday = birthday;
    }

    private String name;
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
