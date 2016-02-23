package com.hopever.springexample.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Donghui Huo on 2015/12/24.
 */
@SpringBootApplication
@EnableJpaRepositories
@EnableCaching
//@EnableJms
//@EnableConfigurationProperties(ActiveMQProperties.class)
@EnableTransactionManagement
public class Application {
//    @Autowired
//    private ActiveMQProperties properties;
    //basic cache of spring in memory cache
//    @Bean(name = "default")
//    public ConcurrentMapCacheFactoryBean concurrentMapCacheFactoryBean() {
//        ConcurrentMapCacheFactoryBean concurrentMapCacheFactoryBean = new ConcurrentMapCacheFactoryBean();
//        return concurrentMapCacheFactoryBean;
//    }

    //jcache proxy,use spring boot,just need to give the provider and config file config is enough
//    public CacheManager cacheManager(@Qualifier("jCacheManager") javax.cache.CacheManager cacheManager) {
//        JCacheCacheManager jc=  new JCacheCacheManager();
//        jc.setCacheManager(cacheManager);
//        return jc;
//    }


//   @Bean
//   ConnectionFactory connectionFactory() {
//       JmsTemplateAutoConfiguration a;
//       return new CachingConnectionFactory(
//               new ActiveMQConnectionFactory(properties.getUser(),properties.getPassword(),properties.getBrokerUrl()));
//   }




    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}