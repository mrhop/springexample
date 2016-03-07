package com.hopever.springexample.integration.jpa.service;

import com.hopever.springexample.integration.jpa.domain.Person;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.List;

/**
 * Created by Donghui Huo on 2016/3/7.
 */
public interface PersonService {

    /**
     * Creates a {@link Person} instance from the {@link Person} instance passed
     *
     * @param person created person instance, it will contain the generated primary key and the formated name
     * @return The persisted Entity
     */
    Person createPerson(Person person);

    /**
     * @return the matching {@link Person} record(s)
     */
    @Payload("new java.util.Date()")
    List<Person> findPeople();

}
