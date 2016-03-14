package com.hopever.springexample.integration.wsinboundgateway;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;

import javax.xml.transform.Source;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Donghui Huo on 2016/3/14.
 */
public class InContainerTests {
    private static Logger logger = LoggerFactory.getLogger(InContainerTests.class);
    private static final String WS_URI = "http://localhost:8080/echoservice";
    private final WebServiceTemplate template = new WebServiceTemplate();
    @Test
    public void testWebServiceRequestAndResponse() {
        StringResult result = new StringResult();
        Source payload = new StringSource(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<echoRequest xmlns=\"http://www.springframework.org/spring-ws/samples/echo\">hello</echoRequest>");

        template.sendSourceAndReceiveToResult(WS_URI, payload, result);
        logger.info("RESULT: " + result.toString());
        assertThat(result.toString(), equalTo(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<echoResponse xmlns=\"http://www.springframework.org/spring-ws/samples/echo\">hello</echoResponse>"));
    }
}
