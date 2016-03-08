package com.hopever.springexample.integration.mongodb.domain;

/**
 * Created by Donghui Huo on 2016/3/8.
 */
public class Address {

    private String street;

    private String city;

    private String zip;

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
