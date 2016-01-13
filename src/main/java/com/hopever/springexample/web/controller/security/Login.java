package com.hopever.springexample.web.controller.security;

import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping(value = "/openidlogin", method = {RequestMethod.GET})
    public String openIdLogin() throws ServletException {
        return "openIdLogin";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout( HttpServletRequest request) throws ServletException {
        request.logout();
        return "login";
    }


    @RequestMapping(value = "/openid/user",method = RequestMethod.GET)
    public String show(Model model, OpenIDAuthenticationToken authentication) {
        model.addAttribute("authentication", authentication);
        return "user/show";
    }
}
