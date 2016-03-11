package com.hopever.springexample.integration.websockets.client;

/**
 * Created by Donghui Huo on 2016/3/11.
 */
public class ClientApplication {



//    public static void main(String[] args) throws Exception {
//        ConfigurableApplicationContext client
//                = new ClassPathXmlApplicationContext("/META-INF/spring/integration/web-sockets/client-context.xml");
//        DirectChannel webSocketInputChannel = client.getBean("webSocketInputChannel", DirectChannel.class);
//
//        final CountDownLatch stopLatch = new CountDownLatch(2);
//
//        webSocketInputChannel.addInterceptor(new ChannelInterceptorAdapter() {
//            @Override
//            public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
//                Object payload = message.getPayload();
//                Date date = null;
//                try {
//                    date = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.DEFAULT).parse((String) payload);
//                }
//                catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                stopLatch.countDown();
//            }
//
//        });
//    }
}
