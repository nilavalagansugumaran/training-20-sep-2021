package com.example.demoSpringWeb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class DemoSpringWebApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DemoSpringWebApplication.class, args);
		log.info(ctx.getBean(Contact.class).toString());
	}

}
