package com.springboot.camel.rest.restreader;

import com.springboot.camel.rest.restreader.model.ClubMember;
import org.apache.camel.*;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.cxf.jaxrs.utils.ParameterizedCollectionType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyProcessor implements Processor {
    @Override
    public void process(Exchange exchange){
        System.out.println("get called: " + exchange.getIn().getBody());

        /*
         * not needed if the route use inOut() method call
         */
        exchange.setPattern(ExchangePattern.InOut);

        Message inMessage = exchange.getIn();

        // using the http central client API
         inMessage.setHeader(CxfConstants.CAMEL_CXF_RS_USING_HTTP_API, Boolean.TRUE);

        // set the Http method
        inMessage.setHeader(Exchange.HTTP_METHOD, "GET");

        inMessage.setHeader(Exchange.ACCEPT_CONTENT_TYPE, "application/json");
        // Specify the response class , cxfrs will use InputStream as the response object type

        /*
         * no need to set response class if you route it to a bean endpoint with a method paramter type string
         */
        //inMessage.setHeader(CxfConstants.CAMEL_CXF_RS_RESPONSE_CLASS, List.class);
        // inMessage.setHeader(CxfConstants.CAMEL_CXF_RS_RESPONSE_CLASS, ClubMember.class);
//        inMessage.setHeader(CxfConstants.CAMEL_CXF_RS_RESPONSE_GENERIC_TYPE, new ParameterizedCollectionType(ClubMember.class));

        /*
         *  set the relative path, if you only set domain address in end point uri like
         *  this: cxfrs://http://localhost:8086
         */
       // inMessage.setHeader(Exchange.HTTP_PATH, "/rest/clubmembers");

        /*
         * pass data to inMessage body
         */
        inMessage.setBody("123");

       // inMessage.setHeader(Exchange.DESTINATION_OVERRIDE_URL,
         //       "http://localhost:8086");
    }

}
