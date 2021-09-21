package com.example.demoSpringAutoConfiguration.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SavingsAccount implements BankAccount{
    @Override
    public void deposit() {
        log.info("This is savings account");
    }
}
