package com.hopever.springexample.integration.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Created by Donghui Huo on 2016/3/4.
 */
public class ActiveMqTestUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActiveMqTestUtils.class);

    public static void prepare() {
        LOGGER.info("Refreshing ActiveMQ data directory.");
        File activeMqTempDir = new File("activemq-data");
        deleteDir(activeMqTempDir);
    }

    private static void deleteDir(File directory){
        if (directory.exists()){
            String[] children = directory.list();
            if (children != null){
                for (int i=0; i < children.length; i++) {
                    deleteDir(new File(directory, children[i]));
                }
            }
        }
        directory.delete();
    }
}
