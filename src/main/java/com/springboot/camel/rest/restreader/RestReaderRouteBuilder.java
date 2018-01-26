package com.springboot.camel.rest.restreader;

import com.springboot.camel.rest.restreader.model.ClubMember;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestReaderRouteBuilder extends RouteBuilder{

    @Override
    public void configure() throws Exception {

        // option 3: use http4
//        from("direct:start")
//                .to("http4:localhost:8086/rest/clubmembers")
//                .to("bean:persistenceBean?method=processData");

        // option 1: do not need have TypeConverter defined
        from("direct:start").
                //-- to("cxfrs:http://localhost:8086/rest/clubmembers")
        to("http://localhost:8086/rest/clubmembers").
               //-- .process(new MyProcessor());
        to("bean:persistenceBean?method=processData");

//        from("direct:start")
//        .to("jetty:http://localhost:8086/rest/clubmembers")
//        .to("bean:persistenceBean?method=persistIncomingData");

        // option 2: need have TypeConverter defined
        // .inOut("cxfrs:...") have a In Message's Body in Exchange of type ResponseImpl
//        from("direct:start").process(new MyProcessor())
//            .inOut("cxfrs://http://localhost:8086/rest/clubmembers")
//                .process(new MyProcessor())
//                .convertBodyTo(ClubMember.class)
//               //-- to("cxfrs://http://localhost:8086/rest/clubmembers")
//                //-- without converter
//                    //-- .to("bean:persistenceBean?method=processData");
//                .to("bean:persistenceBean?method=persistIncomingData");
    }
}
