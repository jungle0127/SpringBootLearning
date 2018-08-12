package com.ps.integration.ftp;

import static org.junit.Assert.assertNotNull;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;

/**
 * Hello world!
 *
 */
public class Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"META-INF/spring/integration/integration.ftp.context.xml");
		PollableChannel ftpChannel = context.getBean("ftpChannel", PollableChannel.class);
		Message<?> msg = ftpChannel.receive(5000);
		System.out.println(String.format("Received first file message: %s.", msg));
		if (msg == null) {
			System.out.println("============Failed=====================");
		}
		else {
			System.out.println("====================GOOD===================");
		}
		context.close();
	}
}
