package com.hopever.springexample.db.amqp;

/**
 * Created by Donghui Huo on 2016/2/23.
 */
//@Configuration
//@ConditionalOnClass({RabbitTemplate.class, AMQP.Channel.class})
//@EnableConfigurationProperties(RabbitProperties.class)
public class RabbitAutoConfiguration {
//
//    @Autowired
//    private ConnectionFactory connectionFactory;
//
//
//
//
//
//    @Bean
//    public RabbitTemplate rabbitTemplate() {
//        RabbitTemplate r=  new RabbitTemplate(this.connectionFactory);
//        r.setChannelTransacted(true);
//        return r;
//    }
//
//    @ConditionalOnClass(RabbitMessagingTemplate.class)
//    @Bean
//    public RabbitMessagingTemplate rabbitMessagingTemplate(
//            RabbitTemplate rabbitTransactionTemplate) {
//        return new RabbitMessagingTemplate(rabbitTransactionTemplate);
//    }

}
