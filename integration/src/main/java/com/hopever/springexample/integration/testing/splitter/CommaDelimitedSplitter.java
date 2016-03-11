package com.hopever.springexample.integration.testing.splitter;

import org.springframework.integration.annotation.Splitter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Donghui Huo on 2016/3/10.
 */
public class CommaDelimitedSplitter {
    @Splitter
    public List<String> split(String input) {
        String[] splits = input.split(",");
        List<String> list = new ArrayList<String>();
        for (String split : splits) {
            String trimmed = split.trim();
            if (trimmed.length() > 0) {
                list.add(trimmed);
            }
        }
        return list;
    }
}
