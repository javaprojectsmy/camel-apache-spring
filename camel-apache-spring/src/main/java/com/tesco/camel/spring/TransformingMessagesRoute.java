package com.tesco.camel.spring;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.XmlJsonDataFormat;

public class TransformingMessagesRoute extends RouteBuilder {

    private final XmlJsonDataFormat xmlJsonFormat;

    public TransformingMessagesRoute() {
        xmlJsonFormat = new XmlJsonDataFormat();
        xmlJsonFormat.setForceTopLevelObject(true);
        xmlJsonFormat.setTrimSpaces(true);
        xmlJsonFormat.setSkipNamespaces(true);
        xmlJsonFormat.setRemoveNamespacePrefixes(true);
    }
    


    @Override
    public void configure() throws Exception {
        from("direct:start")
                .marshal(xmlJsonFormat)
                .to("mock:result");
    }

    
}
