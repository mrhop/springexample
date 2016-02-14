package com.hopever.springexample.db;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheFactoryBean;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Donghui Huo on 2015/12/24.
 */
@SpringBootApplication
@EnableJpaRepositories
@EnableCaching
public class Application {

    //basic cache of spring in memory cache
    @Bean(name = "default")
    public ConcurrentMapCacheFactoryBean concurrentMapCacheFactoryBean() {
        ConcurrentMapCacheFactoryBean concurrentMapCacheFactoryBean = new ConcurrentMapCacheFactoryBean();
        return concurrentMapCacheFactoryBean;
    }

    //jcache proxy
    public CacheManager cacheManager(@Qualifier("jCacheManager") javax.cache.CacheManager cacheManager) {
        JCacheCacheManager jc=  new JCacheCacheManager();
        jc.setCacheManager(cacheManager);
        return jc;
    }
    //do a jcache bean



    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}