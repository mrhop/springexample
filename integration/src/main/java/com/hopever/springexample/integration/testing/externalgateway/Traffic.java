package com.hopever.springexample.integration.testing.externalgateway;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/3/10.
 */
public class Traffic {

    private Map<String, String> incidents = new HashMap<String, String>();

    public void addIncident(String title, String description){
        incidents.put(title, description);
    }

    public Map<String, String> getIncidents(){
        return incidents;
    }

    public String toString(){
        return "Traffic: {" + incidents.keySet().toString() + "}";
    }
}
