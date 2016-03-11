package com.hopever.springexample.integration.testing;

import com.hopever.springexample.integration.util.UtilCommand;
import org.springframework.boot.CommandLineRunner;

/**
 * Created by Donghui Huo on 2016/3/10.
 */
//@Configuration
//@Order(22)
//@ImportResource("META-INF/spring/integration/testing/01-chain/integration-context.xml")
//@ImportResource("META-INF/spring/integration/testing/03-aggregator/integration-context.xml")
//@ImportResource("META-INF/spring/integration/testing/08-errorhandling/integration-context.xml")
//@ImportResource("META-INF/spring/integration/testing/06-filter/integration-context.xml")
//@ImportResource("META-INF/spring/integration/testing/07-gateway/integration-context.xml")
//@ImportResource("META-INF/spring/integration/testing/02-splitter/integration-context.xml")
//@ImportResource("META-INF/spring/integration/testing/04-externalgateway/*.xml")
public class TestingCommand extends UtilCommand implements CommandLineRunner {

//    @Autowired
//    MessageChannel inputChannel;

//    @Autowired
//    QueueChannel testFelineChannel;
//
//    @Autowired
//    QueueChannel testCanineChannel;
//
//    @Autowired
//    QueueChannel testUnknownPetTypeChannel;

//    @Autowired
//    QueueChannel testChannel;
//
//
//    @Autowired
//    VoidGateway gateway;
//    @Autowired
//    MessageChannel inputChannel2;
//
//
//    @Autowired
//    QueueChannel testChannel2;
//
//    @Autowired
//    QueueChannel testDiscardChannel2;


    @Override
    public void run(String... args) throws Exception {
        // for 01-chain
//        String payload = "XXXABCXXX";
//        Message<String> message = MessageBuilder.withPayload(payload).build();
//        inputChannel.send(message);
//        Message<?> outMessage = testChannel.receive(0);
//        Object myHeader = outMessage.getHeaders().get("myHeader");
//        logger.info(myHeader.toString());
//        logger.info(outMessage.getPayload().toString());
        //for 03-aggregator
//        inputChannel.send(MessageBuilder.withPayload("   a   ").build());
//        Message<?> outMessage = testChannel.receive(0);
//        System.out.println(outMessage.getPayload());
//        inputChannel.send(MessageBuilder.withPayload("   a ,z  ").build());
//        outMessage = testChannel.receive(0);
//        System.out.println(outMessage.getPayload());
//        inputChannel.send(MessageBuilder.withPayload("   a ,z , , , ,, ").build());
//        outMessage = testChannel.receive(0);
//        System.out.println(outMessage.getPayload());
        //for 08-errorhandling
//        String payload = "XXXABCXXX";
//        String fileName = "abc.txt";
//        gateway.process(payload, fileName);
//        Message<?> errorMessage = testChannel.receive(0);
//        logger.error(errorMessage.getPayload().toString());

        //for 06-filter
//        String payload = "DOG:Fluffy";
//        Message<String> message = MessageBuilder.withPayload(payload).build();
//        inputChannel.send(message);
//        Message<?> outMessage = testChannel.receive(0);
//        logger.info(outMessage.getPayload().toString());
        //for 07-gateway
//        String payload = "XXXABCXXX";
//        String fileName = "abc.txt";
//        gateway.process(payload, fileName);
//        Message<?> inMessage = testChannel.receive(0);
//        logger.info(inMessage.getHeaders().toString());
//        logger.info(inMessage.getPayload().toString());
        //for 05-router
//        String payload = "CAT:Fluffy";
//        Message<String> message = MessageBuilder.withPayload(payload).build();
//        inputChannel.send(message);
//        Message<?> outMessage = testFelineChannel.receive(0);
//        logger.info(outMessage.getPayload().toString());
        //for 02-splitter
//        inputChannel.send(MessageBuilder.withPayload("   a ,z  ").build());
//        Message<?> outMessage = testChannel.receive(0);
//        logger.info(outMessage.getPayload().toString());
//        outMessage = testChannel.receive(0);
//        logger.info(outMessage.getPayload().toString());
        // for 04-externalgateway
//            WeatherAndTraffic weatherAndTraffic = applicationContext.getBean("wat", WeatherAndTraffic.class);
//            List<String> result = weatherAndTraffic.getByZip("10020");
//            System.out.println(result.get(0) /*+ "\r\n" + result.get(1) + "\r\n"*/);

    }
}
