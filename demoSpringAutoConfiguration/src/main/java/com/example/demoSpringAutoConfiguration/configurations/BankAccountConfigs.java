package com.example.demoSpringAutoConfiguration.configurations;

import com.example.demoSpringAutoConfiguration.components.BankAccount;
import com.example.demoSpringAutoConfiguration.components.CurrentAccount;
import com.example.demoSpringAutoConfiguration.components.SavingsAccount;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankAccountConfigs {

    @Bean
    @ConditionalOnProperty(name = "account.type", havingValue = "current")
    public BankAccount currentAccount(){

        return new CurrentAccount();
    }

    @Bean
    @ConditionalOnProperty(name = "account.type", havingValue = "savings")
    public BankAccount savingsAccount(){

        return new SavingsAccount();
    }
}
