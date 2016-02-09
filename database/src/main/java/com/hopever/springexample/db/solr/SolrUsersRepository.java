package com.hopever.springexample.db.solr;

import org.springframework.data.solr.repository.SolrRepository;

import java.io.Serializable;

/**
 * Created by Donghui Huo on 2016/2/2.
 */
public interface SolrUsersRepository extends SolrRepository<SolrUsers, Serializable> {

}
