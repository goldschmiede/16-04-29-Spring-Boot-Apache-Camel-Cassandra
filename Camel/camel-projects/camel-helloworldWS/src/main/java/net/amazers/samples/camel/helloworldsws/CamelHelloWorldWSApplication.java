package net.amazers.samples.camel.helloworldsws;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
public class CamelHelloWorldWSApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(CamelHelloWorldWSApplication.class, args);
		
		while(true)
		{
			try{Thread.sleep(1000);}catch(Exception e){}
		}
	}
	
	@Bean
	public ServletRegistrationBean servletRegistrationBean() 
	{
		// add mapping for cxf servlet in tomcat
		CXFServlet cxfServlet = new CXFServlet();
	    ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(cxfServlet, "/ws/*");
	    servletRegistrationBean.setLoadOnStartup(1);
	    return servletRegistrationBean;
	}
}


