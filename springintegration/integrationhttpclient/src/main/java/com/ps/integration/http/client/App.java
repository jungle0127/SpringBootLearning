package com.ps.integration.http.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ps.integration.http.client.service.RequestGateway;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"/META-INF/spring/integration/http-outbound-config.xml");
		RequestGateway requestGateway = context.getBean("requestGateway", RequestGateway.class);
		String reply = requestGateway.echo("<Context>\r\n" + 
				"\r\n" + 
				"    <!-- Default set of monitored resources. If one of these changes, the    -->\r\n" + 
				"    <!-- web application will be reloaded.                                   -->\r\n" + 
				"    <WatchedResource>WEB-INF/web.xml</WatchedResource>\r\n" + 
				"    <WatchedResource>${catalina.base}/conf/web.xml</WatchedResource>\r\n" + 
				"\r\n" + 
				"    <!-- Uncomment this to disable session persistence across Tomcat restarts -->\r\n" + 
				"    <!--\r\n" + 
				"    <Manager pathname=\"\" />\r\n" + 
				"    -->\r\n" + 
				"</Context>");
		System.out.println(reply);
		context.close();
	}
}
