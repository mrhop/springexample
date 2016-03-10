package com.hopever.springexample.integration.tcpclientserver;

import org.springframework.core.convert.converter.Converter;

import java.io.UnsupportedEncodingException;

/**
 * Created by Donghui Huo on 2016/3/10.
 */
public class ByteArrayToStringConverter implements Converter<byte[], String> {

    private String charSet = "UTF-8";

    @Override
    public String convert(byte[] bytes) {
        try {
            return new String(bytes, this.charSet);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new String(bytes);
        }
    }

    /**
     * @return the charSet
     */
    public String getCharSet() {
        return charSet;
    }

    /**
     * @param charSet the charSet to set
     */
    public void setCharSet(String charSet) {
        this.charSet = charSet;
    }
}
