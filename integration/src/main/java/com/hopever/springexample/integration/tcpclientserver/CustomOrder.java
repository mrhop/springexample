package com.hopever.springexample.integration.tcpclientserver;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Created by Donghui Huo on 2016/3/10.
 */
public class CustomOrder {
    private int number;
    private String sender;
    private String message;

    public CustomOrder(int number, String sender) {
        this.number = number;
        this.sender = sender;
    }

    public int getNumber() {
        return number;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
