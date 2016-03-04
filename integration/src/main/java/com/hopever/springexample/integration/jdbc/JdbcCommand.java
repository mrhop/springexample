package com.hopever.springexample.integration.jdbc;

import com.hopever.springexample.integration.jdbc.domain.Gender;
import com.hopever.springexample.integration.jdbc.domain.Person;
import com.hopever.springexample.integration.jdbc.service.PersonService;
import com.hopever.springexample.integration.util.UtilCommand;
import org.springframework.boot.CommandLineRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by Donghui Huo on 2016/3/4.
 */
//@Configuration
//@Order(9)
//@ImportResource("/META-INF/spring/integration/jdbc/jdbc-config.xml")
public class JdbcCommand extends UtilCommand implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        final PersonService personService = applicationContext.getBean(PersonService.class);
        getPersonDetails("foo", personService);
        Person person = new Person();
        person.setDateOfBirth(new Date());
        person.setGender(Gender.MALE);
        person.setName("just for test");
        createPersonDetails(person, personService);
        getPersonDetails("just for test", personService);

    }

    /**
     * @param service
     */
    private static void getPersonDetails(String key, final PersonService service) {
        String input = key;
        final List<Person> personList = service.findPersonByName(input);
        if (personList != null && !personList.isEmpty()) {
            for (Person person : personList) {
                System.out.print(
                        String.format("Person found - Person Id: '%d', Person Name is: '%s',  Gender: '%s'",
                                person.getPersonId(), person.getName(), person.getGender()));
                System.out.println(String.format(", Date of birth: '%1$td/%1$tm/%1$tC%1$ty'", person.getDateOfBirth()));
            }
        } else {
            System.out.println(
                    String.format("No Person record found for name: '%s'.", input));
        }
    }

    private static void createPersonDetails(Person person, PersonService service) {
        person = service.createPerson(person);
        System.out.println("Created person record with id: " + person.getPersonId());
    }
}
