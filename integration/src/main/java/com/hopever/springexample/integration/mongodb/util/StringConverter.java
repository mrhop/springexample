package com.hopever.springexample.integration.mongodb.util;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.data.mapping.context.MappingContext;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoPersistentEntity;
import org.springframework.data.mongodb.core.mapping.MongoPersistentProperty;
import org.springframework.util.StringUtils;

/**
 * Created by Donghui Huo on 2016/3/8.
 */
public class StringConverter extends MappingMongoConverter {

    public StringConverter(
            MongoDbFactory mongoDbFactory,
            MappingContext<? extends MongoPersistentEntity<?>, MongoPersistentProperty> mappingContext) {
        super(new DefaultDbRefResolver(mongoDbFactory), mappingContext);
    }

    @Override
    public void write(Object source, DBObject target) {
        String strPerson = ((String[]) source)[0];
        String[] parsedStrPerson = StringUtils.tokenizeToStringArray(strPerson, ",");
        target.put("fname", parsedStrPerson[0]);
        target.put("lname", parsedStrPerson[1]);
        DBObject innerObject = new BasicDBObject();
        innerObject.put("city", parsedStrPerson[2]);
        innerObject.put("street", parsedStrPerson[3]);
        innerObject.put("zip", parsedStrPerson[4]);
        innerObject.put("state", parsedStrPerson[5]);
        target.put("address", innerObject);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <S> S read(Class<S> clazz, DBObject source) {
        return (S) ((source.get("fname") + ", ")
                + source.get("lname") + ", "
                + source.get("city") + ", "
                + source.get("street") + ", "
                + source.get("zip") + ", "
                + source.get("state") + ", ");
    }

}
