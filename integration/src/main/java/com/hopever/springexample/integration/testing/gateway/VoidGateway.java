package com.hopever.springexample.integration.testing.gateway;

import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

/**
 * Created by Donghui Huo on 2016/3/10.
 */
public interface VoidGateway {


    public void process(String thing, @Header(FileHeaders.FILENAME) String fileName);

}
