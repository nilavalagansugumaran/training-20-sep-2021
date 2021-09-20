package com.example.demoWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoWebApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(DemoWebApplication.class, args);
	}

}
