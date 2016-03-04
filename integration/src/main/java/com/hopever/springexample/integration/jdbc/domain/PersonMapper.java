package com.hopever.springexample.integration.jdbc.domain;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Donghui Huo on 2016/3/4.
 */
public class PersonMapper implements RowMapper<Person> {

    /* (non-Javadoc)
     * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
     */
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();
        person.setPersonId(rs.getInt("id"));
        person.setName(rs.getString("name"));
        person.setGender(Gender.getGenderByIdentifier(rs.getString("gender")));
        person.setDateOfBirth(rs.getDate("dateOfBirth"));
        return person;
    }
}