package com.hopever.springexample.resource;

import com.hopever.springexample.domain.User;
import com.hopever.springexample.web.hateoas.UserController;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

/**
 * Created by Donghui Huo on 2015/12/30.
 */
@Component
public class UserResourceAssembler extends ResourceAssemblerSupport<User, UserResource> {

    public UserResourceAssembler() {
        super(UserController.class, UserResource.class);
    }


    @Override
    public UserResource toResource(User entity) {
        UserResource r = createResourceWithId(entity.getId(),entity);
        return r;
    }
}
