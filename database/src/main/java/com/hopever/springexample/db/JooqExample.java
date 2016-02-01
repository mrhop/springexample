package com.hopever.springexample.db;

import com.hopever.springexample.db.jooq.tables.Test;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by huodh on 2/1/16.
 */
@Component
public class JooqExample implements CommandLineRunner {

    private final DSLContext create;

    @Autowired
    public JooqExample(DSLContext dslContext) {
        this.create = dslContext;
    }

    public void run(String... args) {
        this.create.insertInto(Test.TEST,Test.TEST.NAME).values("test测试");
        Object o = this.create.selectFrom(Test.TEST).fetch();
        System.out.println("acb");
    }

}
