package com.hopever.springexample.web.controller.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Donghui Huo on 2016/1/11.
 */
@Controller
public class Login {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() throws ServletException {
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout( HttpServletRequest request) throws ServletException {
        request.logout();
        return "login";
    }
}
