package com.hopever.springexample.web.error.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Donghui Huo on 2015/12/29.
 */
@Controller
public class ErrorController {

    @RequestMapping("/400")
    public String Error400(){
        return "error/400";
    }
}
