package com.springboot.camel.rest.restreader;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.springframework.stereotype.Component;

@Component
public class RestReaderRouteBuilder extends RouteBuilder{

    @Override
    public void configure() throws Exception {
//        from("direct:start").
//                //to("cxfrs:http://localhost:8086/rest/clubmembers")
//        to("http://localhost:8086/rest/clubmembers").
//             //   .process(new MyProcessor());
//        to("bean:persistenceBean?method=persistIncomingData");

//        from("direct:start")
//        .to("jetty:http://localhost:8086/rest/clubmembers")
//        .to("bean:persistenceBean?method=persistIncomingData");

//        from("direct:start").process(new MyProcessor()).
//            inOut("cxfrs://http://localhost:8086/rest/clubmembers").
//               // to("cxfrs://http://localhost:8086/rest/clubmembers")
//                    to("bean:persistenceBean?method=persistIncomingData");
    }
}
