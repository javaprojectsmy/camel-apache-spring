package com.platform.camel.aggregating_messages;

import java.math.BigDecimal;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class InvoiceTotalAggregator implements AggregationStrategy {

    public static final String ITEM_TOTAL_HEADER_NAME = "invoiceItemTotal";

    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if (oldExchange == null) {
            return newExchange;
        }
        BigDecimal currentTotal = oldExchange.getIn().getHeader(ITEM_TOTAL_HEADER_NAME, BigDecimal.class);
        BigDecimal itemTotal = newExchange.getIn().getHeader(ITEM_TOTAL_HEADER_NAME, BigDecimal.class);

        oldExchange.getIn().setHeader(ITEM_TOTAL_HEADER_NAME, currentTotal.add(itemTotal));
        return oldExchange;
    }
}
