package com.wst.bootmqttclient.config;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.endpoint.MessageProducerSupport;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
@Configuration
public class Inbound {
	
	@Bean
	public MqttPahoClientFactory mqttClientFactory() {
		DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
		/*
		factory.setServerURIs("tcp://192.168.19.16:1883");
		factory.setUserName("mqtt-gate-server");
		factory.setPassword("1d50441e-2a1b-4015-aabe-d04d0cb64993");
		*/
		MqttConnectOptions co = new MqttConnectOptions();
		String[] serverURIs = {"tcp://*.*.*.*:1883"};
		co.setServerURIs(serverURIs);
		co.setUserName("ac79c3b3-4f83-4e35-b823-fbea3752e6fc");
		//co.setUserName("6d5a7bba-4f3f-4d64-a323-68b39c45dbe6");
		co.setPassword("4b4facae-0d45-4209-a1fd-15679834f122".toCharArray());
		//co.setPassword("e9cc6fa6-e09b-44c0-9cd3-2f0179f82397".toCharArray());
		factory.setConnectionOptions(co);
		return factory;
	}
	
	@Bean
	public IntegrationFlow mqttInFlow() {
		return IntegrationFlows.from(mqttInbound())
				.transform(p -> p + ", received from MQTT")
				.handle(logger())
				.get();
	}

	private LoggingHandler logger() {
		LoggingHandler loggingHandler = new LoggingHandler("INFO");
		loggingHandler.setLoggerName("siSample");
		return loggingHandler;
	}

	@Bean
	public MessageProducerSupport mqttInbound() {
		MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter("siSampleConsumer",
				mqttClientFactory(), "test-topic");
		adapter.setCompletionTimeout(5000);
		adapter.setConverter(new DefaultPahoMessageConverter());
		adapter.setQos(1);
		return adapter;
	}
}
