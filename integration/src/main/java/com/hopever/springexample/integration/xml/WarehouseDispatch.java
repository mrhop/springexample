package com.hopever.springexample.integration.xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

/**
 * Created by Donghui Huo on 2016/3/14.
 */
public class WarehouseDispatch {
    private static Logger logger = LoggerFactory.getLogger(WarehouseDispatch.class);

    public void dispatch(Document orderItem){
        logger.info("Warehouse dispatching orderItem: \n" + XmlUtil.docAsString(orderItem));
    }
}
