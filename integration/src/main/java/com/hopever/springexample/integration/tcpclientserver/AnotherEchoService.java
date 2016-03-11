package com.hopever.springexample.integration.tcpclientserver;

/**
 * Created by Donghui Huo on 2016/3/10.
 */
public class AnotherEchoService {
    public CustomOrder test(CustomOrder input) {
        if ("FAIL".equals(input)) {
            throw new RuntimeException("Failure Demonstration");
        }
        return input;
    }
}
