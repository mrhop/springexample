package com.hopever.springexample.web.controller;

import com.hopever.springexample.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Donghui Huo on 2015/12/28.
 */
@Controller
@RequestMapping(value = "/simple")
public class SimpleController {

    @RequestMapping(value = "/{name}/{birthday}", method = RequestMethod.GET)
    public String getUser(@ModelAttribute User user
            , Model m) {
        m.addAttribute(user);
        return "index";
    }

    @RequestMapping(value = "/data/{name}/{birthday}", method = RequestMethod.GET)
    public @ResponseBody User getUserAll(@ModelAttribute User user
            , Model m) {
        return user;
    }

}
