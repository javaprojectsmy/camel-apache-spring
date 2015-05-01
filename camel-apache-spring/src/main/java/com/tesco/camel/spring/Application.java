package com.tesco.camel.spring;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class Application {
	public static void main(String[] args) throws Exception {
		CamelContext camelContext = new DefaultCamelContext();
		camelContext.addRoutes(new Routess());
		
		camelContext.setTracing(true);
		camelContext.start();
		Thread.sleep(100000);
		camelContext.stop();
	}
}
