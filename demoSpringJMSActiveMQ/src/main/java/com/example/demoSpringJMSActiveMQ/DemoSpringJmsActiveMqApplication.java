package com.example.demoSpringJMSActiveMQ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@SpringBootApplication
public class DemoSpringJmsActiveMqApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoSpringJmsActiveMqApplication.class, args);
		ctx.getBean(SenderComponent.class).sendGreeting();
		ctx.getBean(SenderComponent.class).sendUserData();
	}

	@Bean
	public MessageConverter jacksonMessageConverter(){
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_id");
		return converter;
	}
}
