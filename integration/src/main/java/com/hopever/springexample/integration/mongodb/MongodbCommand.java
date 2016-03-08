package com.hopever.springexample.integration.mongodb;

import com.hopever.springexample.integration.mongodb.domain.Address;
import com.hopever.springexample.integration.mongodb.domain.Person;
import com.hopever.springexample.integration.mongodb.util.DemoUtils;
import com.hopever.springexample.integration.util.UtilCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

/**
 * Created by Donghui Huo on 2016/3/8.
 */
//@Configuration
//@Order(15)
//@ImportResource("/META-INF/spring/integration/mongodb/mongodb-out-config.xml")
//@ImportResource("/META-INF/spring/integration/mongodb/mongodb-in-config.xml")
public class MongodbCommand extends UtilCommand implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        DemoUtils.prepareMongoFactory(); // will clean up MOngoDb
        //runDefaultAdapter();
        runAdapterWithConveter();

    }



    public void runDefaultAdapter() throws Exception {


        MessageChannel messageChannel = applicationContext.getBean("defaultAdapter", MessageChannel.class);
        messageChannel.send(new GenericMessage<Person>(this.createPersonA()));
        messageChannel.send(new GenericMessage<Person>(this.createPersonB()));
        messageChannel.send(new GenericMessage<Person>(this.createPersonC()));
    }

    public void runAdapterWithConveter() throws Exception {
        MessageChannel messageChannel = applicationContext.getBean("adapterWithConverter", MessageChannel.class);
        messageChannel.send(new GenericMessage<String[]>(new String[]{"John, Dow, Palo Alto, 3401 Hillview Ave, 94304, CA"}));
    }

    private Person createPersonA(){
        Address address = new Address();
        address.setCity("Palo Alto");
        address.setStreet("3401 Hillview Ave");
        address.setZip("94304");
        address.setState("CA");

        Person person = new Person();
        person.setFname("John");
        person.setLname("Doe");
        person.setAddress(address);

        return person;
    }

    private Person createPersonB(){
        Address address = new Address();
        address.setCity("San Francisco");
        address.setStreet("123 Main st");
        address.setZip("94115");
        address.setState("CA");

        Person person = new Person();
        person.setFname("Josh");
        person.setLname("Doe");
        person.setAddress(address);

        return person;
    }

    private Person createPersonC(){
        Address address = new Address();
        address.setCity("Philadelphia");
        address.setStreet("2323 Market st");
        address.setZip("19152");
        address.setState("PA");

        Person person = new Person();
        person.setFname("Jane");
        person.setLname("Doe");
        person.setAddress(address);

        return person;
    }
}
