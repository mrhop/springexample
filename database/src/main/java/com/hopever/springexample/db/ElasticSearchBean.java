package com.hopever.springexample.db;

import com.hopever.springexample.db.elasticsearch.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by huodh on 2/9/16.
 */
@Component
@Order(2)
public class ElasticSearchBean implements CommandLineRunner {

    private ElasticsearchTemplate template;
    @Autowired
    HelloRepository helloRepository;


    @Autowired
    public ElasticSearchBean(ElasticsearchTemplate template) {
        this.template = template;
    }

    @Override
    public void run(String... args) throws Exception {
        //template.getMapping("tutorial","helloworld").size();
        System.out.println("ElasticSearch init:" + template.getMapping("tutorial", "helloworld").size());
        System.out.println("ElasticSearch init:"+helloRepository.findOne("1").getMessage());
    }
}
