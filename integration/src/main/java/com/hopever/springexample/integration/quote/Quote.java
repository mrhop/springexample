package com.hopever.springexample.integration.quote;

import java.math.BigDecimal;

/**
 * Created by Donghui Huo on 2016/3/8.
 */
public class Quote {
    private String ticker;

    private BigDecimal price;

    public Quote(String ticker, BigDecimal price) {
        this.ticker = ticker;
        this.price = price;
    }

    public String toString() {
        return ticker + ": " + price;
    }
}
