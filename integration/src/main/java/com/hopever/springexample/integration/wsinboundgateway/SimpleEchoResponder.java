package com.hopever.springexample.integration.wsinboundgateway;

import org.springframework.integration.xml.source.DomSourceFactory;

import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;

/**
 * Created by Donghui Huo on 2016/3/14.
 */
public class SimpleEchoResponder {
    public Source issueResponseFor(DOMSource request) {
        return new DomSourceFactory().createSource(
                "<echoResponse xmlns=\"http://www.springframework.org/spring-ws/samples/echo\">" +
                        request.getNode().getTextContent() + "</echoResponse>");
    }
}
