package com.springboot.camel.rest.restreader;

import org.apache.camel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestReaderApplication implements CommandLineRunner {

	@Produce(uri="direct:start")
	ProducerTemplate startEndpt;

	@Autowired
	CamelContext camelContext;

	public static void main(String[] args) {

		SpringApplication.run(RestReaderApplication.class, args);
	}

	public void run(String... args) {

		//startEndpt.getDefaultEndpoint().createExchange().setPattern(ExchangePattern.InOut);
		startEndpt.sendBody(null);

		 // "cxfrs://http://localhost:8086/rest/clubmembers"
		//Exchange out = camelContext.createProducerTemplate().send("cxfrs://http://localhost:8086", new MyProcessor());

		/*
		 * API style invoking rest endpoint
		 */
//		Exchange out = camelContext.createProducerTemplate().send("cxfrs://http://localhost:8086/rest/clubmembers", new MyProcessor());
//		System.out.println(out.getOut().getBody());
	}
}
