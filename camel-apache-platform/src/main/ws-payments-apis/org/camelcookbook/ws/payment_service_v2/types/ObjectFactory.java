
package org.camelcookbook.ws.payment_service_v2.types;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.camelcookbook.ws.payment_service_v2.types package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.camelcookbook.ws.payment_service_v2.types
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CheckStatusRequest }
     * 
     */
    public CheckStatusRequest createCheckStatusRequest() {
        return new CheckStatusRequest();
    }

    /**
     * Create an instance of {@link TransferRequest }
     * 
     */
    public TransferRequest createTransferRequest() {
        return new TransferRequest();
    }

    /**
     * Create an instance of {@link TransferResponse }
     * 
     */
    public TransferResponse createTransferResponse() {
        return new TransferResponse();
    }

    /**
     * Create an instance of {@link CheckStatusResponse }
     * 
     */
    public CheckStatusResponse createCheckStatusResponse() {
        return new CheckStatusResponse();
    }

    /**
     * Create an instance of {@link Fault }
     * 
     */
    public Fault createFault() {
        return new Fault();
    }

}
