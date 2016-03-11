package com.hopever.springexample.integration.testing.externalgateway;

import java.util.List;

/**
 * Created by Donghui Huo on 2016/3/10.
 */
public interface WeatherAndTraffic {
    List<String> getByZip(String zip);
}
