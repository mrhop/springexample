package com.hopever.springexample.integration.wsinboundgateway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.ws.SimpleWebServiceInboundGateway;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.context.DefaultMessageContext;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.pox.dom.DomPoxMessage;
import org.springframework.ws.pox.dom.DomPoxMessageFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import java.io.StringReader;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by Donghui Huo on 2016/3/14.
 */
@ContextConfiguration("/META-INF/spring/integration/ws-inbound-gateway/inbound-gateway-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class InboundGatewayTests {

    @Autowired
    private SimpleWebServiceInboundGateway gateway;

    /**
     * Emulate the Spring WS MessageDispatcherServlet by calling the gateway
     * with a DOMSource object representing the payload of the original SOAP
     * 'echoRequest' message.  Expect an 'echoResponse' DOMSource object
     * to be returned in synchronous fashion, which the MessageDispatcherServlet
     * would in turn wrap in a SOAP envelope and return to the client.
     */
    @Test
    public void testSendAndReceive() throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><echoRequest xmlns=\"http://www.springframework.org/spring-ws/samples/echo\">hello</echoRequest>";
        DomPoxMessageFactory messageFactory = new DomPoxMessageFactory();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new InputSource(new StringReader(xml)));
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        DomPoxMessage request = new DomPoxMessage(document, transformer, "text/xml");
        MessageContext messageContext = new DefaultMessageContext(request, messageFactory);
        gateway.invoke(messageContext);
        Object reply = messageContext.getResponse().getPayloadSource();
        assertThat(reply, is(instanceOf(DOMSource.class)));
        DOMSource replySource = (DOMSource) reply;
        Element element = (Element) replySource.getNode().getFirstChild();
        assertThat(element.getTagName(), equalTo("echoResponse"));
    }
}
