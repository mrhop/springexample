package com.hopever.springexample.integration.jpa;

import com.hopever.springexample.integration.jpa.service.PersonService;
import com.hopever.springexample.integration.util.UtilCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;

/**
 * Created by Donghui Huo on 2016/3/7.
 */
//@Configuration
@Component
@Order(12)
public class JpaCommand extends UtilCommand implements CommandLineRunner {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private JpaComponent jpaComponent;
    @Override
    public void run(String... args) throws Exception {
        final PersonService personService = applicationContext.getBean(PersonService.class);
        //findPeople(personService);
        jpaComponent.createPersonDetails("abc-test",personService);
        jpaComponent.findPeople(personService);
    }
}
