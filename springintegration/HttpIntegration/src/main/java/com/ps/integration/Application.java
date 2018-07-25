package com.ps.integration;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ps.integration.gateway.IRequestGateway;

public class Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/integration/http-integration-cfg.xml");
		IRequestGateway requestGateway = context.getBean("requestGateway",IRequestGateway.class);
		String reply = requestGateway.echo("Hello");
		System.out.println("Reply with:" + reply);
		context.close();
		
	}
}
