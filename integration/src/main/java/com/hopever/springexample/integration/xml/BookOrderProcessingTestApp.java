package com.hopever.springexample.integration.xml;

import com.hopever.springexample.integration.util.UtilCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Donghui Huo on 2016/3/14.
 */
//@Configuration
//@Order(26)
//@ImportResource("META-INF/spring/integration/xml/orderProcessingSample.xml")
public class BookOrderProcessingTestApp extends UtilCommand implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        MessageChannel messageChannel = (MessageChannel) applicationContext.getBean("ordersChannel");
        GenericMessage<Document> orderMessage =
                createXmlMessageFromResource("META-INF/spring/integration/xml/order.xml");
        messageChannel.send(orderMessage);
    }

    private static GenericMessage<Document> createXmlMessageFromResource(String path) throws Exception {
        Resource orderRes = new ClassPathResource(path);

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        builderFactory.setNamespaceAware(true);
        DocumentBuilder builder = builderFactory.newDocumentBuilder();

        Document orderDoc = builder.parse(orderRes.getInputStream());
        return new GenericMessage<Document>(orderDoc);
    }
}
