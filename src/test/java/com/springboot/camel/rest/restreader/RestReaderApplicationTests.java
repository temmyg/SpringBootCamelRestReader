package com.springboot.camel.rest.restreader;

import com.springboot.camel.rest.restreader.model.ClubMember;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Message;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.instanceOf;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestReaderApplicationTests  extends CamelSpringTestSupport {

	@Override
	protected AbstractXmlApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("restreader/application-context.xml");
	}

	@Test
	public void testGetCustomerWithHttpCentralClientAPI() {
		Exchange exchange = template.send("direct://http", newExchange -> {
			newExchange.setPattern(ExchangePattern.InOut);
			Message inMessage = newExchange.getIn();
			// using the http central client API
			inMessage.setHeader(CxfConstants.CAMEL_CXF_RS_USING_HTTP_API, Boolean.TRUE);
			// set the Http method
			inMessage.setHeader(Exchange.HTTP_METHOD, "GET");
			// set the relative path
			inMessage.setHeader(Exchange.HTTP_PATH, "localhost:8086/rest/clubmembers");
//			inMessage.setHeader(Exchange.HTTP_PATH, "rest/clubmembers");
//            inMessage.setHeader(Exchange.HTTP_PATH, "/customerservice/customers/123");
			// Specify the response class , cxfrs will use InputStream as the response object type
//            inMessage.setHeader(CxfConstants.CAMEL_CXF_RS_RESPONSE_CLASS, Customer.class);
			// set a customer header
			inMessage.setHeader("key", "value");
			// since we use the Get method, so we don't need to set the message body
			inMessage.setBody(null);
		});


		// get the response message
		Object response = exchange.getOut().getBody();

		assertNotNull("The response should not be null ", response);
//		assertEquals("Get a wrong customer id ", 123, response.getId());
//		assertEquals("Get a wrong customer name", "John", response.getName());
		assertEquals("Get a wrong response code", 200, exchange.getOut().getHeader(Exchange.HTTP_RESPONSE_CODE));
		assertEquals("Get a wrong header value", "value", exchange.getOut().getHeader("key"));
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void MessageBodyCustomTypeConversionTest() {
		Exchange response = template.send("cxfrs://http://localhost:8086/rest/clubmembers", newExchange -> {

			newExchange.setPattern(ExchangePattern.InOut);
			Message inMessage = newExchange.getIn();

			inMessage.setHeader(Exchange.HTTP_METHOD, "GET");
			inMessage.setHeader("Accept", "application/json");
			//
			//inMessage.setHeader(Exchange.HTTP_PATH, "/customerservice/customers/123");

			inMessage.setHeader(CxfConstants.CAMEL_CXF_RS_RESPONSE_CLASS, ClubMember.class);
		});

		String result = response.getOut().getBody().toString();

		assertThat(result.getClass(), instanceOf(ClubMember.class));
	//	Exchange exchange =
	}
}
