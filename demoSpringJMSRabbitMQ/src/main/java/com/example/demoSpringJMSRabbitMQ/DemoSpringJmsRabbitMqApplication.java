package com.example.demoSpringJMSRabbitMQ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoSpringJmsRabbitMqApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DemoSpringJmsRabbitMqApplication.class, args);
		ctx.getBean(SenderComponent.class).sendUserData();
	}

}
