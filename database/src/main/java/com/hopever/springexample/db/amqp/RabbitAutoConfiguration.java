package com.hopever.springexample.db.amqp;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Donghui Huo on 2016/2/23.
 */
@Configuration
@ConditionalOnClass({RabbitTemplate.class, AMQP.Channel.class})
@EnableConfigurationProperties(RabbitProperties.class)
public class RabbitAutoConfiguration {

    @Autowired
    private ConnectionFactory connectionFactory;





    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate r=  new RabbitTemplate(this.connectionFactory);
        r.setChannelTransacted(true);
        return r;
    }

    @ConditionalOnClass(RabbitMessagingTemplate.class)
    @Bean
    public RabbitMessagingTemplate rabbitMessagingTemplate(
            RabbitTemplate rabbitTransactionTemplate) {
        return new RabbitMessagingTemplate(rabbitTransactionTemplate);
    }

}
