package com.springboot.camel.rest.restreader;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.impl.DefaultEndpoint;
import org.apache.camel.impl.DefaultProducer;
import org.springframework.stereotype.Component;

@Component
public class MyProcessor implements Processor {
    @Override
    public void process(Exchange exchange){
        System.out.println("get called");
    }
}
