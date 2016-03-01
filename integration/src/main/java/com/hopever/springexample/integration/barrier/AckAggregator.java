package com.hopever.springexample.integration.barrier;

import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.integration.aggregator.MessageGroupProcessor;
import org.springframework.integration.store.MessageGroup;
import org.springframework.messaging.Message;

/**
 * Created by Donghui Huo on 2016/3/1.
 */
public class AckAggregator implements MessageGroupProcessor {

    @Override
    public Object processMessageGroup(MessageGroup group) {
        StringBuilder builder = new StringBuilder("Result: ");
        for (Message<?> message : group.getMessages()) {
            if (builder.length() > 8) {
                builder.append(", ");
            }
            builder.append(message.getPayload() + ": ack=" + message.getHeaders().get(AmqpHeaders.PUBLISH_CONFIRM));
        }
        return builder.toString();
    }

}