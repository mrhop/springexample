package com.hopever.springexample.db;

import com.hopever.springexample.db.jooq.tables.Test;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/2/2.
 */
@Component
@Order(2)
public class RedisBean implements CommandLineRunner {
    private StringRedisTemplate template;

    @Autowired
    public RedisBean(StringRedisTemplate template) {
        this.template = template;
    }

    @Autowired
    private JooqExample jooqExample;

    @Override
    public void run(String... args) throws Exception {
        Result o = jooqExample.getCreate().selectFrom(Test.TEST).fetch();
        BoundHashOperations<String, String, String> ops = template.boundHashOps("PRIMARY-ID:"+o.field(0));
        Map<String, String> data = new HashMap<String, String>();
        data.put("id", String.valueOf(o.field(0)));
        data.put("name", String.valueOf(o.field(1)));
        ops.putAll(data);
    }
}
