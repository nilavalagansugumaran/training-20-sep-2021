package com.example.demoSpringAOP;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
@Slf4j
public class DemoSpringAopApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DemoSpringAopApplication.class, args);

		ctx.getBean("currentAccount", BankAccount.class).deposit(100);
		ctx.getBean("currentAccount", BankAccount.class).withdraw(50);

		ctx.getBean("savingsAccount", BankAccount.class).deposit(1000);
		ctx.getBean("savingsAccount", BankAccount.class).withdraw(150);

	}

}
