package com.hopever.springexample.db.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by huodh on 2/12/16.
 */
public interface HelloRepository extends ElasticsearchRepository<Hello, String> {
}
