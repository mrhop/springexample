package com.hopever.springexample.db.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.destination.DestinationResolver;

import javax.jms.ConnectionFactory;

/**
 * Created by Donghui Huo on 2016/2/17.
 */
@Configuration
public class JmsConfig {
    @Autowired
    private JmsProperties properties;

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired(required = false)
    private JmsListenerContainerFactory jmsListenerContainerFactory;

    @Autowired(required = false)
    private DestinationResolver destinationResolver;

    @Bean
    JmsListenerContainerFactory jmsListenerContainerPubSubFactory() throws IllegalAccessException, InstantiationException {
        JmsListenerContainerFactory jmsListenerContainerPubSubFactory = jmsListenerContainerFactory.getClass().newInstance();
        DefaultJmsListenerContainerFactory djcf = new DefaultJmsListenerContainerFactory();
        djcf.setConnectionFactory(connectionFactory);
        djcf.setPubSubDomain(true);
        djcf.setSessionTransacted(true);
        djcf.setAutoStartup(true);
        return djcf;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate(this.connectionFactory);
        jmsTemplate.setPubSubDomain(this.properties.isPubSubDomain());
        if (this.destinationResolver != null) {
            jmsTemplate.setDestinationResolver(this.destinationResolver);
        }
        return jmsTemplate;
    }

    @Bean
    public JmsMessagingTemplate jmsMessagingTemplate(JmsTemplate jmsTemplate) {
        return new JmsMessagingTemplate(jmsTemplate);
    }

    @Bean
    public JmsTemplate jmsPubSubTemplate() throws IllegalAccessException, InstantiationException {
        JmsTemplate jmsTemplate = new JmsTemplate(this.connectionFactory);
        jmsTemplate.setPubSubDomain(true);
        if (this.destinationResolver != null) {
            jmsTemplate.setDestinationResolver(this.destinationResolver);
        }
        return jmsTemplate;
    }

    @Bean
    public JmsMessagingTemplate jmsMessagingPubSubTemplate(JmsTemplate jmsPubSubTemplate) {
        return new JmsMessagingTemplate(jmsPubSubTemplate);
    }
}
