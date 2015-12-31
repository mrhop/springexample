package com.hopever.springexample.web.hateoas;

import com.hopever.springexample.domain.User;
import com.hopever.springexample.resource.UserResource;
import com.hopever.springexample.resource.UserResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by Donghui Huo on 2015/12/29.
 */
@Controller
@EnableEntityLinks
@RequestMapping("/user/hateoas")
public class UserController {
    @Resource
    UserResourceAssembler ura;

    @Autowired
    private EntityLinks entityLinks;

    @Value("${myhost.domain}")
    private String host;

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<UserResource> showAll() {
        User u= new User();
        u.setId(123);
        u.setBirthday(new Date());
        u.setName("you know");
        UserResource ur = new UserResource();
        ur.setName("you know");
        ur.setBirthday(new Date());
        Link link = linkTo(UserController.class).withRel("/");
        ur.add(this.entityLinks.linkToSingleResource(UserResource.class, ur.getId()));
        return new ResponseEntity<UserResource>(ur, HttpStatus.OK);
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
