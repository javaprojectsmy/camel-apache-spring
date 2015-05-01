package com.tesco.camel.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
    public static void main(String[] args) throws Exception {
        AbstractApplicationContext springContext = new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
        
        springContext.start();
        Thread.sleep(100000);
        springContext.stop();
    }
}
