package com.hopever.springexample.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.annotation.IntegrationComponentScan;

/**
 * Created by Donghui Huo on 2016/2/29.
 */
@SpringBootApplication
@IntegrationComponentScan
public class Application {



    public static void main(String[] args) {

     SpringApplication.run(Application.class, args);
//        TempConverter converter = ctx.getBean(TempConverter.class);
//        System.out.println("where is it?"+converter.fahrenheitToCelcius(68.0f));
//        ctx.close();
//        System.exit(0);
    }

//    @MessagingGateway
//    public interface TempConverter {
//
//        @Gateway(requestChannel = "convert.input")
//        float fahrenheitToCelcius(float fahren);
//
//    }
//
//    @Bean
//    public IntegrationFlow convert() {
//        return f -> f
//                .transform(payload ->"<FahrenheitToCelsius xmlns=\"http://www.w3schools.com/xml/\">"
//                                +     "<Fahrenheit>" + payload +"</Fahrenheit>"
//                                + "</FahrenheitToCelsius>")
//                .enrichHeaders(h -> h
//                        .header(WebServiceHeaders.SOAP_ACTION,
//                                "http://www.w3schools.com/xml/FahrenheitToCelsius"))
//                .handle(new SimpleWebServiceOutboundGateway(
//                        "http://www.w3schools.com/xml/tempconvert.asmx"))
//                .transform(Transformers.xpath("/*[local-name()=\"FahrenheitToCelsiusResponse\"]"
//                        + "/*[local-name()=\"FahrenheitToCelsiusResult\"]"));
//    }

}
