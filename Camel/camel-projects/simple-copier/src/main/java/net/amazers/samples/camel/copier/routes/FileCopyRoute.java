package net.amazers.samples.camel.copier.routes;

import java.time.LocalDateTime;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.cxf.message.MessageContentsList;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class FileCopyRoute extends RouteBuilder
{
	private static final Logger log = Logger.getLogger(FileCopyRoute.class);
	
	@Override
	public void configure() throws Exception 
	{
		from("file:target/folderA")
		.to("log:fileFolderA")
		.to("file:target/folderB");
	}
	
	private void processProvideResposne(Exchange exchange)
	{
		String response = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mms=\"http://com.vattenfall.vet.mmscom/wsdl/MMS_MOL_Message_v1\" xmlns:mms1=\"http://com.vattenfall.vet.mmscom/MMS_MOL_Message_v1\" xmlns:mms2=\"http://com.vattenfall.vet.mmscom/MMSBase_v1\">"
				+ "<soapenv:Header/>"
				+ "  <soapenv:Body>"
				+ "     <mms:MMSMOLMessageResponse>"
				+ "         <mms1:MessageId>MSG-DUMMY-RESPONSE</mms1:MessageId>"
				+ "         <mms1:Result>"
				+ "            <mms2:Result>Success</mms2:Result>"
				+ "            <mms2:ResultMessage>OK</mms2:ResultMessage>"
				+ "         </mms1:Result>"
				+ "      </mms:MMSMOLMessageResponse>"
				+ "   </soapenv:Body>"
				+ "</soapenv:Envelope>";
		
		exchange.getOut().setBody(response);
	}
}
