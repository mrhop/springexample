package com.hopever.springexample.integration.xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

/**
 * Created by Donghui Huo on 2016/3/14.
 */
public class ExternalResupply {
    private static Logger logger = LoggerFactory.getLogger(ExternalResupply.class);

    public void orderResupply(Document resupplyOrder) {
        logger.info("Placing resupply order: \n" + XmlUtil.docAsString(resupplyOrder));
    }
}
