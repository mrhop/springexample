package com.hopever.springexample.integration.enricher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Donghui Huo on 2016/3/2.
 */
//@Configuration
//@Order(4)
//@ImportResource("/META-INF/spring/integration/enricher/enricher-context.xml")
public class EnricherCommand implements CommandLineRunner, ApplicationContextAware {

    private static Logger logger = LoggerFactory.getLogger(EnricherCommand.class);
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void run(String... args) throws Exception {
        ((AbstractApplicationContext) applicationContext).registerShutdownHook();

        final Scanner scanner = new Scanner(System.in);

        final UserService service = applicationContext.getBean(UserService.class);

        while (!scanner.hasNext("q")) {

            final String input = scanner.nextLine();

            User user = new User("foo", null, null);

            if ("1".equals(input)) {

                final User fullUser = service.findUser(user);
                printUserInformation(fullUser);

            } else if ("2".equals(input)) {

                final User fullUser = service.findUserByUsername(user);
                printUserInformation(fullUser);

            } else if ("3".equals(input)) {

                final Map<String, Object> userData = new HashMap<String, Object>();
                userData.put("username", "foo_map");

                final Map<String, Object> enrichedUserData = service.findUserWithUsernameInMap(userData);

                final User fullUser = (User) enrichedUserData.get("user");

                printUserInformation(fullUser);

            } else {
                logger.info("\n\n    Please enter '1', '2', or '3' <enter>:\n\n");
            }

        }

        logger.info("\n\nExiting application...bye.");

    }

    private static void printUserInformation(User user) {

        if (user != null) {
            logger.info(String.format("\n\n    User found - Username: '%s',  Email: '%s', Password: '%s'.\n\n",
                    user.getUsername(), user.getEmail(), user.getPassword()));

        } else {
            logger.info("\n\n    No User found for username: 'foo'.\n\n");
        }

    }
}
