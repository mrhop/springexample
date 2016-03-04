package com.hopever.springexample.integration.jmx;

import com.hopever.springexample.integration.util.UtilCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Donghui Huo on 2016/3/4.
 */
@Configuration
@Order(11)
@ImportResource("/META-INF/spring/integration/jmx/jmx-config.xml")
@ManagedResource
public class JmxCommand extends UtilCommand  implements CommandLineRunner{
    private final ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();

    private volatile Future<?> future;

    private final AtomicInteger seconds = new AtomicInteger();

    @ManagedAttribute
    public int getSeconds() {
        return this.seconds.get();
    }

    @ManagedOperation
    public void start() {
        this.scheduler.initialize();
        this.future = this.scheduler.scheduleAtFixedRate(new Runnable() {
            public void run() {
                seconds.incrementAndGet();
            }
        }, 1000);
    }

    @ManagedOperation
    public void stop() {
        this.future.cancel(true);
    }

    @ManagedOperation
    public void reset() {
        this.seconds.set(0);
    }

    @Override
    public void run(String... args) throws Exception {
        this.start();
    }
}
