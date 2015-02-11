package com.platform.camel.connecting_routes;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConnectingRoutesSpringTest extends CamelSpringTestSupport {

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("META-INF/spring/connecting-routes-context.xml");
    }

    @Produce(uri = "direct:start")
    protected ProducerTemplate start;

    @EndpointInject(uri = "mock:result")
    private MockEndpoint mockResult;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        context.getRouteDefinition("generatorRoute").adviceWith(context, new AdviceWithRouteBuilder() {
            @Override
            public void configure() throws Exception {
                replaceFromWith("direct:start");
            }
        });
    }

    @Test
    public void deliversMessagesToNextRoute() throws Exception {
        mockResult.expectedBodiesReceived("Test message");

        start.sendBody("Test message");
        mockResult.assertIsSatisfied();
    }
}

