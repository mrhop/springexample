package com.hopever.springexample.integration.testing.filter;

import org.springframework.integration.annotation.Filter;

/**
 * Created by Donghui Huo on 2016/3/10.
 */
public class PetFilter {

    @Filter
    public boolean dogsOnly(String input) {
        return input.toLowerCase().contains("dog");
    }
}
