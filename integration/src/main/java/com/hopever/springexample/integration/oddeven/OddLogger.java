package com.hopever.springexample.integration.oddeven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Donghui Huo on 2016/3/8.
 */
@MessageEndpoint
public class OddLogger {
    private static Logger logger = LoggerFactory.getLogger(OddLogger.class);

    @ServiceActivator
    public void log(int i) {
        logger.info("odd:  " + i + " at " + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
    }
}
