package com.hopever.springexample.db;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

/**
 * Created by huodh on 2/1/16.
 */
//@Component
//@Order(1)
public class JooqExample implements CommandLineRunner {

    private final DSLContext create;

    @Autowired
    public JooqExample(DSLContext dslContext) {
        this.create = dslContext;
    }

    public void run(String... args) {
//        this.create.insertInto(Test.TEST,Test.TEST.ID,Test.TEST.NAME).values(1,"test测试").execute();
//        Object o = this.create.selectFrom(Test.TEST).fetch();
//        System.out.println("acb");
    }

}
