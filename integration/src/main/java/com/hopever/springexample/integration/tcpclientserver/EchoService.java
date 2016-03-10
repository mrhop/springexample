package com.hopever.springexample.integration.tcpclientserver;

/**
 * Created by Donghui Huo on 2016/3/10.
 */
public class EchoService {
    public String test(String input) {
        if ("FAIL".equals(input)) {
            throw new RuntimeException("Failure Demonstration");
        }
        return "echo:" + input;
    }
}
