package com.hopever.springexample.integration.testing.externalgateway;

/**
 * Created by Donghui Huo on 2016/3/10.
 */
public class Weather {
    private String city;
    private String state;
    private String temperature;
    private String description;

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getTemperature() {
        return temperature;
    }
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String toString(){
        return description + " in " + city +
                ", " + state + "; Temperature " + temperature + "";
    }
}
