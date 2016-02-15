package com.hopever.springexample.db.elasticsearch;

/**
 * Created by huodh on 2/12/16.
 */
//@Document(indexName = "tutorial", type = "helloworld", shards = 1, replicas = 0)
public class Hello {

    private String id;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
