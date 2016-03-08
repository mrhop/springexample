package com.hopever.springexample.integration.quote;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * Created by Donghui Huo on 2016/3/8.
 */
@MessageEndpoint
public class QuoteService {

    @ServiceActivator(inputChannel = "tickers", outputChannel = "quotes")
    public Quote lookupQuote(String ticker) {
        BigDecimal price = new BigDecimal(new Random().nextDouble() * 100);//NOSONAR
        return new Quote(ticker, price.setScale(2, RoundingMode.HALF_EVEN));
    }

}
