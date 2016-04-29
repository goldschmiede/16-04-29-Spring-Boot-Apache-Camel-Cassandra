package net.amazers.samples.camel.copier;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
public class CopierSampleApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(CopierSampleApplication.class, args);
		
		while(true)
		{
			try{Thread.sleep(1000);}catch(Exception e){}
		}
	}
}


