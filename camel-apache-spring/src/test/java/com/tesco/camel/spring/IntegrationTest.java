
package com.tesco.camel.spring;

import junit.framework.TestCase;
import org.apache.camel.spring.Main;

/**
 * @version 
 */
public class IntegrationTest extends TestCase {

    public void testCamelRulesDeployCorrectlyInSpring() throws Exception {
        // let's boot up the Spring application context for 2 seconds to check that it works OK
        Main.main("-duration", "2s", "-o", "target/site/cameldoc");
    }
}
