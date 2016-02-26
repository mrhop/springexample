package com.hopever.springexample.db.rdbs;

//import com.hopever.springexample.db.jooq.tables.pojos.Test;
import com.hopever.springexample.db.jooq.h2.tables.pojos.Test;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

/**
 * Created by Donghui Huo on 2016/2/25.
 */
public interface TestRepository extends CrudRepository<Test, Serializable> {
}
