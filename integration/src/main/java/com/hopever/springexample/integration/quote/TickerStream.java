package com.hopever.springexample.integration.quote;

import java.util.Random;

/**
 * Created by Donghui Huo on 2016/3/8.
 */
public class TickerStream {

    public String nextTicker() {
        char[] chars = new char[3];
        for (int i = 0; i < 3; i++) {
            chars[i] = (char) (new Random().nextInt(25) + 65);
        }
        return new String(chars);
    }

}
