package com.hopever.springexample.integration.amqp;

import org.springframework.boot.CommandLineRunner;

/**
 * Created by Donghui Huo on 2016/3/1.
 */
//@Configuration
//@Order(1)
public class AmqpCommand implements CommandLineRunner {

//    @Bean
//    public MessageChannel amqpInputChannel() {
//        return new DirectChannel();
//    }
//
//    @Bean
//    public AmqpInboundChannelAdapter inbound(SimpleMessageListenerContainer listenerContainer,
//                                             @Qualifier("amqpInputChannel") MessageChannel channel) {
//        AmqpInboundChannelAdapter adapter = new AmqpInboundChannelAdapter(listenerContainer);
//        adapter.setOutputChannel(channel);
//        return adapter;
//    }
//
//    @Bean
//    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {
//        SimpleMessageListenerContainer container =
//                new SimpleMessageListenerContainer(connectionFactory);
//        container.setQueueNames("test");
//        container.setConcurrentConsumers(2);
//        // ...
//        return container;
//    }
//
//    @Bean
//    @ServiceActivator(inputChannel = "amqpInputChannel")
//    public MessageHandler handler() {
//        return new MessageHandler() {
//
//            @Override
//            public void handleMessage(Message<?> message) throws MessagingException {
//                System.out.println(message.getPayload().toString());
//            }
//
//        };
//    }
//
//
////    @Bean
////    public IntegrationFlow amqpInbound(ConnectionFactory connectionFactory) {
////        return IntegrationFlows.from(Amqp.inboundAdapter(connectionFactory, "test"))
////                .handle(m -> System.out.println(m.getPayload()))
////                .get();
////    }
    @Override
    public void run(String... args) throws Exception {

    }
}
