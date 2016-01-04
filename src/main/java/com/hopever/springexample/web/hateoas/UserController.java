package com.hopever.springexample.web.hateoas;

import com.hopever.springexample.domain.User;
import com.hopever.springexample.repository.UserRepository;
import com.hopever.springexample.resource.UserResource;
import com.hopever.springexample.resource.UserResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by Donghui Huo on 2015/12/29.
 */
@Controller
@RequestMapping("/user/hateoas")
@ExposesResourceFor(User.class)
public class UserController {
    @Resource
    UserResourceAssembler ura;

    @Autowired
    private EntityLinks entityLinks;

    @Autowired
    private UserRepository userRepository;


    @Value("${myhost.domain}")
    private String host;

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<Resources<User>> showAll() {
        Resources<User> resources = new Resources<User>(this.userRepository.findAll());
        resources.add(this.entityLinks.linkToCollectionResource(User.class));
        return new ResponseEntity<Resources<User>>(resources, HttpStatus.OK);
    }
    @RequestMapping(path="/json",method = RequestMethod.GET)
    @ResponseBody
    public UserResource showAllWithJson() {
        UserResource ur = new UserResource();
        ur.setName("you know");
        ur.setBirthday(new Date());
       // ur.setUser(u);
        ur.add(new Link("http://"+host+"/people"));
        return ur;
    }

    @RequestMapping(path="/urs",method = RequestMethod.GET)
    public HttpEntity<UserResource> showAllWithAssemble() {
        User u= new User();
        u.setBirthday(new Date());
        u.setName("you know");
        u.setId(123);
        return new ResponseEntity<UserResource>(ura.toResource(u), HttpStatus.OK);
    }


}
