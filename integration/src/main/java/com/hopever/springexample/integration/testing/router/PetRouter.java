package com.hopever.springexample.integration.testing.router;

import org.springframework.integration.annotation.Router;

/**
 * Created by Donghui Huo on 2016/3/10.
 */
public class PetRouter {
    @Router
    public String route(String input) {
        if (input.toLowerCase().contains("cat")) {
            return "felineChannel";
        }
        if (input.toLowerCase().contains("dog")) {
            return "canineChannel";
        }
        return "unknownPetTypeChannel";
    }

}
