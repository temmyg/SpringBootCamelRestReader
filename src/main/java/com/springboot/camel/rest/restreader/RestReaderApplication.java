package com.springboot.camel.rest.restreader;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestReaderApplication implements CommandLineRunner {

	@Produce(uri="direct:start")
	ProducerTemplate startEndpt;

	public static void main(String[] args) {

		SpringApplication.run(RestReaderApplication.class, args);
	}

	public void run(String... args) {
		startEndpt.sendBody(null);
	}
}
