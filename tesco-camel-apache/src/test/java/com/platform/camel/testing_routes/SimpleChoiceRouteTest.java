package com.platform.camel.testing_routes;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class SimpleChoiceRouteTest extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new SimpleChoiceRoute();
    }

    @Produce(uri = "direct:start")
    protected ProducerTemplate start;

    @EndpointInject(uri = "mock:oranges")
    private MockEndpoint mockOranges;

    @EndpointInject(uri = "mock:apples")
    private MockEndpoint mockApples;

    @Test
    public void routesMessagesToSeparateEndpoints() throws Exception {
        mockOranges.expectedBodiesReceived("orange");
        mockApples.expectedBodiesReceived("apple");

        start.sendBody("orange");
        start.sendBody("apple");
        assertMockEndpointsSatisfied();
    }
}
