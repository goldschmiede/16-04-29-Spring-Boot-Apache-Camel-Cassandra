package net.amazers.samples.camel.helloworldsws.routes;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class WSRoute extends RouteBuilder
{
	private static final Logger log = Logger.getLogger(WSRoute.class);
	
	@Override
	public void configure() throws Exception 
	{
		from( "cxf:/HelloWorld?"
                + "wsdlURL=wsdl/HelloWorld.wsdl&"
                + "dataFormat=PAYLOAD" ) 
		.to( "file:{{application.targetdir}}" )
//        .setExchangePattern( ExchangePattern.In ) // this is required to be able to add a response to the exchange
//        .to( "rabbitmq://dummy/{{amqp.exchange}}?addresses={{amqp.hosts}}&vhost={{amqp.vhost}}&routingKey={{amqp.routingKey}}" +
//                "&username={{amqp.user}}&password={{amqp.passwd}}&exchangeType=topic&autoDelete=false&declare=false&skipQueueDeclare=true" )
//        .setExchangePattern( ExchangePattern.InOut ) // this is required to be able to add a response to the exchange
        .to( "log:Hello-received" )
        .process( this::processWsResponse )
        ;

	}


    private void processWsResponse( Exchange exchange )
	{
        String response =
        		  "<urn:sayHelloResponse xmlns:urn=\"urn:examples:helloservice\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">"
        		+ "   <greeting>Hello, this is Camel Responding. Roger!</greeting>"
        		+ "</urn:sayHelloResponse>";
        exchange.getOut().setBody( response );
	}
}
