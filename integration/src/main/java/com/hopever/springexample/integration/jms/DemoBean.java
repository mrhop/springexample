package com.hopever.springexample.integration.jms;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * Created by Donghui Huo on 2016/3/4.
 */
@MessageEndpoint
public class DemoBean {
    @ServiceActivator
    public String upperCase(String input) {
        return "JMS response: " + input.toUpperCase();
    }
}
