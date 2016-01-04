package com.hopever.springexample.web.controller;

import com.hopever.springexample.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Donghui Huo on 2015/12/28.
 */
@Controller
@RequestMapping(value = "/simple")
public class SimpleController {

    final static Logger logger = LoggerFactory.getLogger(SimpleController.class);



    @Resource
    private ConversionService mvcConversionService;

    @RequestMapping(value = "/{name}/{birthday}", method = RequestMethod.GET)
    public String getUser(@PathVariable String name, User user
            , Model m) {
        m.addAttribute(user);
        return "index";
    }


    @RequestMapping(value = "/user/{user}", method = RequestMethod.GET)
    public String getUser(@PathVariable User user
            , Model m) {
        m.addAttribute(user);
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST,params={"do=save"})
    public String addUser(
            final User user, final BindingResult bindingResult, final ModelMap m) {
       // m.addAttribute(user);
        //do save
        /*logger.info(mvcConversionService.convert(user.getBirthday(),String.class));
        logger.info(mvcConversionService.convert("1933-11-11",Date.class).toString());
*/        m.addAttribute(user);
        return "index";
    }

    @RequestMapping(value = "/data/{name}/{birthday}", method = RequestMethod.GET)
    public @ResponseBody User getUserAll(User user
            , Model m) {
        return user;
    }

    class MobileValidator implements Validator {

        public boolean supports(Class<?> classObject) {
            return classObject == User.class;
        }

        public void validate(Object object, Errors errors) {

            User user = (User)object;
            if (user.getName() == null || user.getName().trim().length() == 0){
                errors.rejectValue("name", "name.required", "Name field is missing");
            }
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class,"birthday1", new CustomDateEditor(
                dateFormat, false));
    }


}
