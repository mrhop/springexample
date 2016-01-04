package com.hopever.springexample.web.Config;

import com.hopever.springexample.web.jersey.Endpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * Created by Donghui Huo on 2016/1/4.
 */
@Component
@ApplicationPath("/jersey")/*very important for filter the only path*/
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        packages("com.hopever.springexample.web.jersey");
        register(Endpoint.class);
    }

}
