package com.hopever.springexample.db.solr;

/**
 * Created by Donghui Huo on 2016/2/2.
 */
//@SolrDocument( solrCoreName ="gettingstarted" )
public class SolrUsers {

    //@Id
    //@Field(value = "id")
    private  Integer id;

    //@Field(value = "name")
    private  String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
