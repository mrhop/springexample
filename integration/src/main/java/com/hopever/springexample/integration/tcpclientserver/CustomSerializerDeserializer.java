package com.hopever.springexample.integration.tcpclientserver;

import com.hopever.springexample.integration.util.UtilCommand;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.serializer.Deserializer;
import org.springframework.core.serializer.Serializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Donghui Huo on 2016/3/10.
 */
public class CustomSerializerDeserializer implements Serializer<CustomOrder>, Deserializer<CustomOrder> {
    protected static Logger logger = LoggerFactory.getLogger(UtilCommand.class);

    private static final int ORDER_NUMBER_LENGTH = 3;
    private static final int SENDER_NAME_LENGTH = 10;
    private static final int MESSAGE_LENGTH_LENGTH = 6;

    /**
     * Convert a CustomOrder object into a byte-stream
     *
     * @param object
     * @param outputStream
     * @throws IOException
     */
    public void serialize(CustomOrder object, OutputStream outputStream) throws IOException {
        byte[] number = Integer.toString(object.getNumber()).getBytes();
        outputStream.write(number);

        byte[] senderName = object.getSender().getBytes();
        outputStream.write(senderName);

        String lenghtPadded = pad(6, object.getMessage().length());
        byte[] length = lenghtPadded.getBytes();
        outputStream.write(length);

        outputStream.write(object.getMessage().getBytes());
        outputStream.flush();
    }

    private String pad(int desiredLength, int length) {
        return StringUtils.leftPad(Integer.toString(length), desiredLength, '0');
    }

    /**
     * Convert a raw byte stream into a CustomOrder
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public CustomOrder deserialize(InputStream inputStream) throws IOException {
        int orderNumber = parseOrderNumber(inputStream);
        String senderName = parseSenderName(inputStream);

        CustomOrder order = new CustomOrder(orderNumber, senderName);
        String message = parseMessage(inputStream);
        order.setMessage(message);
        return order;
    }

    private String parseMessage(InputStream inputStream) throws IOException {
        String lengthString = parseString(inputStream, MESSAGE_LENGTH_LENGTH);
        int lengthOfMessage = Integer.valueOf(lengthString);

        String message = parseString(inputStream, lengthOfMessage);
        return message;
    }

    private String parseString(InputStream inputStream, int length) throws IOException {
        StringBuilder builder = new StringBuilder();

        int c;
        for (int i = 0; i < length; ++i) {
            c = inputStream.read();
            checkClosure(c);
            builder.append((char)c);
        }

        return builder.toString();
    }

    private String parseSenderName(InputStream inputStream) throws IOException {
        return parseString(inputStream, SENDER_NAME_LENGTH);
    }

    private int parseOrderNumber(InputStream inputStream) throws IOException {
        String value = parseString(inputStream, ORDER_NUMBER_LENGTH);
        return Integer.valueOf(value.toString());
    }

    /**
     * Check whether the byte passed in is the "closed socket" byte
     * Note, I put this in here just as an example, but you could just extend the
     * {@link org.springframework.integration.ip.tcp.serializer.AbstractByteArraySerializer} class
     * which has this method
     *
     * @param bite
     * @throws IOException
     */
    protected void checkClosure(int bite) throws IOException {
        if (bite < 0) {
            logger.debug("Socket closed during message assembly");
            throw new IOException("Socket closed during message assembly");
        }
    }
}
