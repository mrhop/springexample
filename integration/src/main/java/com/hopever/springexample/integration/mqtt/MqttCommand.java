package com.hopever.springexample.integration.mqtt;

/**
 * Created by Donghui Huo on 2016/3/8.
 */
//@Configuration
//@Order(16)
//public class MqttCommand extends UtilCommand implements CommandLineRunner {
//    @Override
//    public void run(String... args) throws Exception {
//
//        logger.info("\n========================================================="
//                + "\n                                                         "
//                + "\n          Welcome to Spring Integration!                 "
//                + "\n                                                         "
//                + "\n    For more information please visit:                   "
//                + "\n    https://spring.io/projects/spring-integration        "
//                + "\n                                                         "
//                + "\n=========================================================" );
//
//        logger.info("\n========================================================="
//                + "\n                                                          "
//                + "\n    This is the MQTT Sample -                             "
//                + "\n                                                          "
//                + "\n    Please enter some text and press return. The entered  "
//                + "\n    Message will be sent to the configured MQTT topic,    "
//                + "\n    then again immediately retrieved from the Message     "
//                + "\n    Broker and ultimately printed to the command line.    "
//                + "\n                                                          "
//                + "\n=========================================================" );
//
//    }
//
//    @Bean
//    public MqttPahoClientFactory mqttClientFactory() {
//        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
//        factory.setServerURIs("tcp://localhost:1883");
//        factory.setUserName("guest");
//        factory.setPassword("guest");
//        return factory;
//    }
//
//    // publisher
//
//    @Bean
//    public IntegrationFlow mqttOutFlow() {
//        return IntegrationFlows.from(CharacterStreamReadingMessageSource.stdin(),
//                e -> e.poller(Pollers.fixedDelay(1000)))
//                .transform(p -> p + " sent to MQTT")
//                .handle(mqttOutbound())
//                .get();
//    }
//
//    @Bean
//    public MessageHandler mqttOutbound() {
//        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler("siSamplePublisher", mqttClientFactory());
//        messageHandler.setAsync(true);
//        messageHandler.setDefaultTopic("siSampleTopic");
//        return messageHandler;
//    }
//
//    // consumer
//
//    @Bean
//    public IntegrationFlow mqttInFlow() {
//        return IntegrationFlows.from(mqttInbound())
//                .transform(p -> p + ", received from MQTT")
//                .handle(logger())
//                .get();
//    }
//
//    private LoggingHandler logger() {
//        LoggingHandler loggingHandler = new LoggingHandler("INFO");
//        loggingHandler.setLoggerName("siSample");
//        return loggingHandler;
//    }
//
//    @Bean
//    public MessageProducerSupport mqttInbound() {
//        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter("siSampleConsumer",
//                mqttClientFactory(), "siSampleTopic");
//        adapter.setCompletionTimeout(5000);
//        adapter.setConverter(new DefaultPahoMessageConverter());
//        adapter.setQos(1);
//        return adapter;
//    }
//}
