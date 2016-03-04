package com.hopever.springexample.integration.jdbc.domain;

/**
 * Created by Donghui Huo on 2016/3/4.
 */
public class User {
    private String username;
    private String password;
    private String email;

    public User(String username, String password, String email) {
        super();
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }
}
