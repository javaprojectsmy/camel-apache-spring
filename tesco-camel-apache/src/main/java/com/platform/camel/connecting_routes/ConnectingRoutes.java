
package com.platform.camel.connecting_routes;

import org.apache.camel.builder.RouteBuilder;

public class ConnectingRoutes extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:logger")
                .id("loggerRoute")
                .to("log:org.apache.camel.howto.logger?level=INFO")
                .to("mock:result");

        from("timer://start?fixedRate=true&period=1000")
                .id("generatorRoute")
                .to("log:org.apache.camel.howto.generator?level=INFO")
                .to("direct:logger");
    }
}
