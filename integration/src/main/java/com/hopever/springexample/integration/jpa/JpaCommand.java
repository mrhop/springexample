package com.hopever.springexample.integration.jpa;

import com.hopever.springexample.integration.jpa.domain.Person;
import com.hopever.springexample.integration.jpa.service.PersonService;
import com.hopever.springexample.integration.util.UtilCommand;
import org.springframework.boot.CommandLineRunner;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Donghui Huo on 2016/3/7.
 */
//@Configuration
//@Order(12)
//@ImportResource("/META-INF/spring/integration/jpa/jpa-config.xml")
public class JpaCommand extends UtilCommand implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        final PersonService personService = applicationContext.getBean(PersonService.class);
        findPeople(personService);
        createPersonDetails("abc-test",personService);
        findPeople(personService);
    }

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");

    private void createPersonDetails(String name,PersonService service) {
        Person person = new Person();
        person.setName(name);
        person = service.createPerson(person);
        System.out.println("Created person record with id: " + person.getId());
    }
    /**
     * @param service
     */
    private void findPeople(final PersonService service) {
        System.out.println("ID            NAME         CREATED");
        System.out.println("==================================");

        final List<Person> people = service.findPeople();

        if(people != null && !people.isEmpty()) {
            for(Person person : people) {
                System.out.print(String.format("%d, %s, ", person.getId(), person.getName()));
                System.out.println(DATE_FORMAT.format(person.getCreatedDateTime()));//NOSONAR
            }
        } else {
            System.out.println(
                    String.format("No Person record found."));
        }

        System.out.println("==================================\n\n");

    }
}
