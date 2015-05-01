package com.tesco.camel.spring;

import org.apache.camel.builder.RouteBuilder;

public class UsingComponentsRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("jetty:http://localhost:8181?matchOnUriPrefix=true")
                .to("log:org.apache.camel.howto?showAll=true&multiline=true")
                .to("tibco:queue:sample");
    }

}

