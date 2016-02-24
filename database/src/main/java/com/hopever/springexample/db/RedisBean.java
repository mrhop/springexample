package com.hopever.springexample.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Donghui Huo on 2016/2/2.
 */
@Component
@Order(2)
public class RedisBean implements CommandLineRunner {

//    @Autowired
//    private RedisService redisService;
//
//    @Autowired
//    private StringRedisTemplate template;

    @Override
    public void run(String... args) throws Exception {
//        try {
//            redisService.saveMap();
//        }catch (Exception e){
//            System.out.println("some transaction works");
//        }
//        //template.opsForValue().set("foo","bar123");
//        System.out.println( "Redis-after transaction--"+template.opsForValue().get("foo"));
//        System.out.println("Redis-after transaction"+template.opsForHash().hasKey("just hash Test","1"));
//        System.out.println("Redis-after transaction"+template.opsForHash().entries("just hash Test").size());
//        template.opsForValue().set("foo","nothing for transaction");
//        template.opsForHash().delete("just hash Test","1");
//        template.opsForHash().delete("just hash Test","2");
    }
}
