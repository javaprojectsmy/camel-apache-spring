
package com.platform.camel.app;

import org.apache.camel.builder.RouteBuilder;

public class MoveFileRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file://source")
                .to("log://org.apache.camel.howto?showAll=true&multiline=true")
                .to("file://target");
    }
}
