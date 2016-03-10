package com.hopever.springexample.integration.splunk;

/**
 * Created by Donghui Huo on 2016/3/10.
 */
//@Configuration
//@Order(19)
//@ImportResource("META-INF/spring/integration/splunk/si-splunk-example-context.xml")
//public class SplunkCommand extends UtilCommand implements CommandLineRunner {
//
//    @Value("${splunk.host}")
//    private String host;
//    @Value("${splunk.port}")
//    private String port;
//    @Value("${splunk.username}")
//    private String username;
//    @Value("${splunk.password}")
//    private String password;
//    @Value("${splunk.owner}")
//    private String owner;
//
//    @Override
//    public void run(String... args) throws Exception {
//        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
//        MessageChannel channelRestOutput = context.getBean("toSplunk", MessageChannel.class);
//        sendWithRest(channelRestOutput);
//        System.out.println("Consumer");
//    }
//
//    private static void sendWithRest(MessageChannel channel) {
//
//        for (int i = 0; i < 10; i++) {
//            channel.send(MessageBuilder.withPayload(createEvent()).build());
//        }
//
//    }
//
//    private static SplunkEvent createEvent(){
//        int nextInt = ThreadLocalRandom.current().nextInt(1, 1000);
//        OrderEvent sd = new OrderEvent();
//        sd.setEan(String.valueOf (nextInt));
//        sd.setEmailuser("mail@gmail.com");
//        sd.setOrderNumber("21501001010101");
//        return sd;
//    }
//
//    @Bean
//    public SplunkServer splunkServerRef() {
//        SplunkServer splunkServer = new SplunkServer();
//        splunkServer.setPort(Integer.valueOf(port));
//        splunkServer.setHost(host);
//        splunkServer.setUsername(username);
//        splunkServer.setOwner(owner);
//        splunkServer.setPassword(password);
//        return splunkServer;
//    }
//}
