package com.hopever.springexample.db;

import com.hopever.springexample.db.solr.SolrUsersRepository;
import org.apache.solr.client.solrj.SolrServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by huodh on 2/9/16.
 */
@Component
@Order(1)
public class SolrBean  implements CommandLineRunner {

    private SolrServer solr;
    @Autowired
    SolrUsersRepository solrUsersRepository;

    @Autowired
    public SolrBean(SolrServer solr) {
        this.solr = solr;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.print(solrUsersRepository.count());
        //solr.addBean()
        System.out.println("solr init");
    }
}
