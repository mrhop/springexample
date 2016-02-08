package com.hopever.springexample.db.mongodb;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Donghui Huo on 2016/2/2.
 */
@Document(collection = "Users")
public class Users {

    private  String username;
    private  String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
