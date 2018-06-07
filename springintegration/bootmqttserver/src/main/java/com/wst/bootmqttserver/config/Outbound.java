package com.wst.bootmqttserver.config;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.stream.CharacterStreamReadingMessageSource;
import org.springframework.messaging.MessageHandler;

@Configuration
public class Outbound {
	@Bean
	public MqttPahoClientFactory mqttClientFactory() {
		DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
		MqttConnectOptions csmpConnectionOptions = new MqttConnectOptions();
		String[] serverURIs = { "tcp://192.168.19.16:1883" };
		csmpConnectionOptions.setServerURIs(serverURIs);
		csmpConnectionOptions.setUserName("mqtt-gate-server");
		csmpConnectionOptions.setPassword("1d50441e-2a1b-4015-aabe-d04d0cb64993".toCharArray());
		factory.setConnectionOptions(csmpConnectionOptions);
		return factory;
	}

	
	
	@Bean
	public IntegrationFlow mqttOutFlow() {
		return IntegrationFlows
				.from(CharacterStreamReadingMessageSource.stdin(), e -> e.poller(Pollers.fixedDelay(1000)))
				.transform(p -> p + " sent to MQTT").handle(mqttOutbound()).get();
	}
	
	@Bean
	public MessageHandler mqttOutbound() {
		MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler("siSamplePublisher", mqttClientFactory());
		messageHandler.setAsync(true);
		messageHandler.setDefaultTopic("ps-topic");
		return messageHandler;
	}
}
