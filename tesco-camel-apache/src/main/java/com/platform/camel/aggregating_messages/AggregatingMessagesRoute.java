package com.platform.camel.aggregating_messages;

import org.apache.camel.builder.RouteBuilder;

public class AggregatingMessagesRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:start")
                .aggregate(header("invoiceId"), new InvoiceTotalAggregator())
                .completionTimeout(500)
                .to("mock:aggregated");
    }

}
