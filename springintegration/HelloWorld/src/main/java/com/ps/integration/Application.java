package com.ps.integration;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;

public class Application {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/integration/helloworldintegration.xml",Application.class);
		MessageChannel inputChannel = context.getBean("inputChannel",MessageChannel.class);
		PollableChannel outputChannel = context.getBean("outputChannel",PollableChannel.class);
		inputChannel.send(new GenericMessage<String>("Spring Integration Hello World DEMO."));
		System.out.println(outputChannel.receive().getPayload());
		context.close();
	}
}
