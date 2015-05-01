package com.tesco.camel.spring;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.Main;

public class Routess extends RouteBuilder {
//	 public static void main(String[] args) throws Exception {
//	 new Main().run(args);
//	 }
	LocalConstants constant;

	public void configure() {
		
		from(constant.LOCAL_FILE_SYSTEM).setHeader("create", constant("create")).to(constant.QUEUE_CREATE_ORDER);
		from(constant.QUEUE_CREATE_ORDER).filter(header("create").isEqualTo("create")).to(constant.QUEUE_ORDER_CREATED);
	
		from("file:src/abcs?noop=true").setHeader("cancel", constant("cancel")).to(constant.QUEUE_CREATE_ORDER);
		from(constant.QUEUE_CREATE_ORDER).filter(header("cancel").isEqualTo("cancel")).to(constant.QUEUE_CANCEL_ORDER);
		
		
		
		from("jms:queue:test.rkp").to("tibco:queue:sample");
		// filtering routes
	/*	from("direct:start1").filter(header("userStatus").isEqualTo("valid"))
				.to("mock:valid").end().to("mock:all");

		// re organizing routes
		from("direct:start").resequence(header("message_index")).batch()
				.size(100).timeout(1000L).to("mock:result");

		// printing messages from file target
		from("file://target/test?noop=true").bean(new SomeBean());

		// connecting routes
		from("direct:logger")
				.id("loggerRoute")
				.to("log:com.platform.camel.connecting_routes.logger?level=INFO")
				.to("mock:result");

		from("timer://start?fixedRate=true&period=1000")
				.id("generatorRoute")
				.to("log:com.platform.camel.connecting_routes.generator?level=INFO")
				.to("direct:logger");

		
		
		// multicasting routes

		 from("activemq:topic:aman")
		 .multicast()
		 .parallelProcessing()
		 .to("activemq:topic:aman1", "activemq:topic:aman2", "activemq:topic:aman3")
		 .end()
		 .to("activemq:topic:aman4");

	
		
		// routing to diffrent destinations

		from("file://source")
				.choice()
				.when(simple("${in.header.CamelFileName} contains 'widget.txt'"))
				.to("file://widget")
				.when(simple("${in.header.CamelFileName} contains 'gadget.txt'"))
				.to("file://gadget").otherwise()
				.to("log://org.apache.camel.howto");

		// spliting message routes
		from("direct:start2").split(xpath("//invoice/item/product"))
				.convertBodyTo(String.class).to("mock:products").end()
				.to("mock:result");

		// choosing routes
		from("direct:start3").choice().when(body().isEqualTo("orange"))
				.to("mock:oranges").when(body().isEqualTo("apple"))
				.to("mock:apples");
		
		*/

		
		
		// printing messages from file target
				from("file://target/test?noop=true").bean(new SomeBean());
	}

	public static class SomeBean {

		public void someMethod(String body) {
			System.out.println("Received: " + body);
		}
	}

}
