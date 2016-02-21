package com.hopever.springexample.db.jms;

import org.springframework.context.annotation.Configuration;

/**
 * Created by Donghui Huo on 2016/2/17.
 */
@Configuration
public class JmsConfig {
//    @Autowired
//    private JmsProperties properties;

//    @Autowired
//    private ConnectionFactory connectionFactory;
//
//    @Autowired(required = false)
//    private JmsListenerContainerFactory jmsListenerContainerFactory;
//
//    @Autowired(required = false)
//    private DestinationResolver destinationResolver;
//
//    @Bean
//    JmsListenerContainerFactory jmsListenerContainerPubSubFactory() throws IllegalAccessException, InstantiationException {
//        JmsListenerContainerFactory jmsListenerContainerPubSubFactory = jmsListenerContainerFactory.getClass().newInstance();
//        DefaultJmsListenerContainerFactory djcf = new DefaultJmsListenerContainerFactory();
//        djcf.setConnectionFactory(connectionFactory);
//        djcf.setPubSubDomain(true);
//        djcf.setSessionTransacted(true);
//        djcf.setAutoStartup(true);
//        return djcf;
//    }
//
//    @Bean
//    public JmsTemplate jmsTemplate() {
//        JmsTemplate jmsTemplate = new JmsTemplate(this.connectionFactory);
//        jmsTemplate.setPubSubDomain(this.properties.isPubSubDomain());
//        if (this.destinationResolver != null) {
//            jmsTemplate.setDestinationResolver(this.destinationResolver);
//        }
//        return jmsTemplate;
//    }
//
//    @Bean
//    public JmsMessagingTemplate jmsMessagingTemplate(JmsTemplate jmsTemplate) {
//        return new JmsMessagingTemplate(jmsTemplate);
//    }
//
//    @Bean
//    public JmsTemplate jmsPubSubTemplate() throws IllegalAccessException, InstantiationException {
//        JmsTemplate jmsTemplate = new JmsTemplate(this.connectionFactory);
//        jmsTemplate.setPubSubDomain(true);
//        if (this.destinationResolver != null) {
//            jmsTemplate.setDestinationResolver(this.destinationResolver);
//        }
//        return jmsTemplate;
//    }
//
//    @Bean
//    public JmsMessagingTemplate jmsMessagingPubSubTemplate(JmsTemplate jmsPubSubTemplate) {
//        return new JmsMessagingTemplate(jmsPubSubTemplate);
//    }
}
