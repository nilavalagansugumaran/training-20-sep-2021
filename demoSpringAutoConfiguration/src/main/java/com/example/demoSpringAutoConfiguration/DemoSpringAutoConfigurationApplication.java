package com.example.demoSpringAutoConfiguration;

import com.example.demoSpringAutoConfiguration.components.BankAccount;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoSpringAutoConfigurationApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoSpringAutoConfigurationApplication.class, args);
		//ctx.getBean("currentAccount", BankAccount.class).deposit();
		//ctx.getBean("savingsAccount", BankAccount.class).deposit();
		ctx.getBean(BankAccount.class).deposit();
	}

}
