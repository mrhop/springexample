package com.hopever.springexample.integration.jdbc.service;

import com.hopever.springexample.integration.jdbc.domain.Person;

import java.util.List;

/**
 * Created by Donghui Huo on 2016/3/4.
 */
public interface PersonService {


    /**
     * Creates a {@link Person} instance from the {@link Person} instance passed
     *
     * @param person created person instance, it will contain the generated primary key and the formatted name
     * @return the retrieved {@link Person}
     */
    Person createPerson(Person person);

    /**
     * Find the person by the person name, the name search is case insensitive, however the
     * spaces are not ignored
     *
     * @param name
     * @return the matching {@link Person} record
     */
    List<Person> findPersonByName(String name);
}
