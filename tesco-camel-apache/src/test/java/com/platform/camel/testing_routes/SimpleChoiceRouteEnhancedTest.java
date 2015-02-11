package com.platform.camel.testing_routes;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

@RunWith(CamelSpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"classpath:/META-INF/spring/testing-route-context.xml"})
public class SimpleChoiceRouteEnhancedTest {

    @Autowired
    private CamelContext camelContext;

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
        MockEndpoint.assertIsSatisfied(camelContext);
    }
}
