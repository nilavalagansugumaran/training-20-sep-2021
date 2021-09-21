package com.example.demoSpringRestClient;

import com.example.demoSpringRestClient.component.ClientComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoSpringRestClientApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoSpringRestClientApplication.class, args);
		ctx.getBean(ClientComponent.class).callEmployeeService();
	}

}
