package com.hopever.springexample.integration.testing.aggregator;

import org.springframework.integration.annotation.Aggregator;

import java.util.List;

/**
 * Created by Donghui Huo on 2016/3/10.
 */
public class CommaDelimitedAggregator {
    @Aggregator
    public String aggregate(List<String> bits) {
        StringBuilder sb = new StringBuilder();
        for (String bit : bits) {
            sb.append(bit).append(",");
        }
        // remove final comma, if any
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        if (sb.length() < 1) {
            return null;
        }
        return sb.toString();
    }
}
