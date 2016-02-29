package com.hopever.springexample.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.support.Transformers;
import org.springframework.integration.ws.SimpleWebServiceOutboundGateway;
import org.springframework.integration.ws.WebServiceHeaders;

/**
 * Created by Donghui Huo on 2016/2/29.
 */
@SpringBootApplication
@IntegrationComponentScan
public class Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        TempConverter converter = ctx.getBean(TempConverter.class);
        System.out.println("where is it?"+converter.fahrenheitToCelcius(68.0f));
        ctx.close();

    }

    @MessagingGateway
    public interface TempConverter {

        @Gateway(requestChannel = "convert.input")
        float fahrenheitToCelcius(float fahren);

    }

    @Bean
    public IntegrationFlow convert() {
        return f -> f
                .transform(payload ->"<FahrenheitToCelsius xmlns=\"http://www.w3schools.com/webservices/\">"
                                +     "<Fahrenheit>" + payload +"</Fahrenheit>"
                                + "</FahrenheitToCelsius>")
                .enrichHeaders(h -> h
                        .header(WebServiceHeaders.SOAP_ACTION,
                                "http://www.w3schools.com/webservices/FahrenheitToCelsius"))
                .handle(new SimpleWebServiceOutboundGateway(
                        "http://www.w3schools.com/webservices/tempconvert.asmx"))
                .transform(Transformers.xpath("/*[local-name()=\"FahrenheitToCelsiusResponse\"]"
                        + "/*[local-name()=\"FahrenheitToCelsiusResult\"]"));
    }

}
