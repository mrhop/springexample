package com.hopever.springexample.integration.oddeven;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Donghui Huo on 2016/3/8.
 */
public class Counter {
    private final AtomicInteger count = new AtomicInteger();

    public int next() {
        int nextNumber = count.incrementAndGet();
        return (nextNumber % 5 == 0) ? -nextNumber : nextNumber;
    }
}
