package com.springboot.camel.rest.restreader;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestReaderRouteBuilder extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        //from("direct:start").
        from("cxfrs:http://localhost:8086/rest/clubmembers")
        //to("http://localhost:8086/rest/clubmembers")
                .process(new MyProcessor());
             //   .to("bean:persistenceBean?method=persistIncomingData");
    }
}
