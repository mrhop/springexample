package com.hopever.springexample.integration.websockets;

import com.hopever.springexample.integration.util.UtilCommand;
import org.apache.catalina.Context;
import org.apache.tomcat.websocket.server.WsSci;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.ExecutorChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.integration.splitter.DefaultMessageSplitter;
import org.springframework.integration.transformer.AbstractPayloadTransformer;
import org.springframework.integration.transformer.HeaderEnricher;
import org.springframework.integration.transformer.support.ExpressionEvaluatingHeaderValueMessageProcessor;
import org.springframework.integration.websocket.ServerWebSocketContainer;
import org.springframework.integration.websocket.outbound.WebSocketOutboundMessageHandler;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.support.GenericMessage;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.Executors;

/**
 * Created by Donghui Huo on 2016/3/11.
 */
//@Configuration
//@Order(23)
public class WebSocketsCommand extends UtilCommand implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

    }

    @Bean
    public TomcatEmbeddedServletContainerFactory tomcatContainerFactory() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setTomcatContextCustomizers(Arrays.asList(new TomcatContextCustomizer[] {
                tomcatContextCustomizer()
        }));
        return factory;
    }

    @Bean
    public TomcatContextCustomizer tomcatContextCustomizer() {
        return new TomcatContextCustomizer() {
            @Override
            public void customize(Context context) {
                context.addServletContainerInitializer(new WsSci(), null);
            }
        };
    }


    @Bean
    public ServerWebSocketContainer serverWebSocketContainer() {
        return new ServerWebSocketContainer("/time").withSockJs();
    }

    @Bean
    @InboundChannelAdapter(value = "splitChannel", poller = @Poller(fixedDelay = "1000", maxMessagesPerPoll = "1"))
    public MessageSource<?> webSocketSessionsMessageSource() {
        return new MessageSource<Iterator<String>>() {

            @Override
            public Message<Iterator<String>> receive() {
                return new GenericMessage<Iterator<String>>(serverWebSocketContainer().getSessions().keySet().iterator());
            }

        };
    }

    @Bean
    public MessageChannel splitChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "splitChannel")
    public MessageHandler splitter() {
        DefaultMessageSplitter splitter = new DefaultMessageSplitter();
        splitter.setOutputChannelName("headerEnricherChannel");
        return splitter;
    }

    @Bean
    public MessageChannel headerEnricherChannel() {
        return new ExecutorChannel(Executors.newCachedThreadPool());
    }

    @Bean
    @Transformer(inputChannel = "headerEnricherChannel", outputChannel = "transformChannel")
    public HeaderEnricher headerEnricher() {
        return new HeaderEnricher(Collections.singletonMap(SimpMessageHeaderAccessor.SESSION_ID_HEADER,
                new ExpressionEvaluatingHeaderValueMessageProcessor<Object>("payload", null)));
    }

    @Bean
    @Transformer(inputChannel = "transformChannel", outputChannel = "sendTimeChannel")
    public AbstractPayloadTransformer<?, ?> transformer() {
        return new AbstractPayloadTransformer<Object, Object>() {
            @Override
            protected Object transformPayload(Object payload) throws Exception {
                return DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.DEFAULT).format(new Date());
            }

        };
    }


    @Bean
    public MessageChannel sendTimeChannel() {
        return new PublishSubscribeChannel();
    }


    @Bean
    @ServiceActivator(inputChannel = "sendTimeChannel")
    public MessageHandler webSocketOutboundAdapter() {
        return new WebSocketOutboundMessageHandler(serverWebSocketContainer());
    }

    @Bean
    @ServiceActivator(inputChannel = "sendTimeChannel")
    public MessageHandler loggingChannelAdapter() {
        LoggingHandler loggingHandler = new LoggingHandler("info");
        loggingHandler.setExpression("'The time ' + payload + ' has been sent to the WebSocketSession ' + headers.simpSessionId");
        return loggingHandler;
    }

}
