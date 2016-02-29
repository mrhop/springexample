package com.hopever.springexample.db.jms;

import org.springframework.context.annotation.Configuration;

/**
 * Created by Donghui Huo on 2016/2/17.
 */
@Configuration
public class JmsConfig {
//    @Autowired
//    private JmsProperties properties;
//
//    @Autowired
//    private ConnectionFactory connectionFactory;
//
//    @Autowired(required = false)
//    private JmsListenerContainerFactory jmsListenerContainerFactory;
//
//    @Autowired(required = false)
//    private DestinationResolver destinationResolver;
//
//    @Autowired(required = false)
//    private JtaTransactionManager transactionManager;
//
//    @Bean
//    public DefaultJmsListenerContainerFactory jmsListenerContainerPubSubFactory(
//            ConnectionFactory connectionFactory) {
//        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//        ((DefaultJmsListenerContainerFactory)jmsListenerContainerFactory).setRecoveryInterval(5000l);
//        factory.setConnectionFactory(connectionFactory);
//        factory.setPubSubDomain(true);
//        if (this.transactionManager != null) {
//            factory.setTransactionManager(this.transactionManager);
//        }
//        else {
//            factory.setSessionTransacted(true);
//        }
//        if (this.destinationResolver != null) {
//            factory.setDestinationResolver(this.destinationResolver);
//        }
//        JmsProperties.Listener listener = this.properties.getListener();
//        factory.setAutoStartup(listener.isAutoStartup());
//        if (listener.getAcknowledgeMode() != null) {
//            factory.setSessionAcknowledgeMode(listener.getAcknowledgeMode().getMode());
//        }
//        String concurrency = listener.formatConcurrency();
//        if (concurrency != null) {
//            factory.setConcurrency(concurrency);
//        }
//        return factory;
//    }
//
//    @Bean
//    public JmsTemplate jmsTemplate() {
//        JmsTemplate jmsTemplate = new JmsTemplate(this.connectionFactory);
//        jmsTemplate.setPubSubDomain(this.properties.isPubSubDomain());
//        if (this.destinationResolver != null) {
//            jmsTemplate.setDestinationResolver(this.destinationResolver);
//        }
//        //jmsTemplate.setSessionTransacted(true);
//        return jmsTemplate;
//    }
//
//    @Bean
//    public JmsMessagingTemplate jmsMessagingTemplate(JmsTemplate jmsTemplate) {
//        return new JmsMessagingTemplate(jmsTemplate);
//    }

//    @Bean
//    public JmsTemplate jmsPubSubTemplate() throws IllegalAccessException, InstantiationException {
//        JmsTemplate jmsTemplate = new JmsTemplate(this.connectionFactory);
//        jmsTemplate.setPubSubDomain(true);
//        if (this.destinationResolver != null) {
//            jmsTemplate.setDestinationResolver(this.destinationResolver);
//        }
//       jmsTemplate.setSessionTransacted(true);
//        return jmsTemplate;
//    }
//
//    @Bean
//    public JmsMessagingTemplate jmsMessagingPubSubTemplate(JmsTemplate jmsPubSubTemplate) {
//        return new JmsMessagingTemplate(jmsPubSubTemplate);
//    }
}
