package com.tesco.camel.spring;

import java.util.ResourceBundle;

public class LocalConstants {
	 static ResourceBundle rb = ResourceBundle.getBundle("propertyfiles.queues_n_topics");
	
		
		public static final String 
				QUEUE_CREATE_ORDER = rb.getString("queueCreateOrder"),
				QUEUE_ORDER_CREATED = rb.getString("queueOrderCreated"),
				QUEUE_CANCEL_ORDER =  rb.getString("queueOrderCancelled"),
				LOCAL_FILE_SYSTEM = rb.getString("filesystem");
	

}
