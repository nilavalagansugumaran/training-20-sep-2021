package com.example.demoBeans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoBeansApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(DemoBeansApplication.class, args);
		context.getBean(MyBean.class).doSomething();
		System.out.println(context.getBean(MyBean.class).hashCode());
		System.out.println(context.getBean(MyBean.class).hashCode());
		System.out.println(context.getBean(MyBean.class).hashCode());
		System.out.println(context.getBean(MyBean.class).hashCode());
	}

}
