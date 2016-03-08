package com.hopever.springexample.integration.mongodb.util;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Donghui Huo on 2016/3/8.
 */
public class DemoUtils {

    public static MongoDbFactory prepareMongoFactory(String... additionalCollectionToDrop) throws Exception{
        List<MongoCredential> list =new ArrayList<MongoCredential>();
        MongoCredential credentials =MongoCredential.createCredential("picture","picture", "picture".toCharArray());
        list.add(credentials);
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(new MongoClient(new ServerAddress(),list), "picture");
        MongoTemplate template = new MongoTemplate(mongoDbFactory);
        template.dropCollection("messages");
        template.dropCollection("data");
        for (String additionalCollection : additionalCollectionToDrop) {
            template.dropCollection(additionalCollection);
        }
        return mongoDbFactory;
    }
}
