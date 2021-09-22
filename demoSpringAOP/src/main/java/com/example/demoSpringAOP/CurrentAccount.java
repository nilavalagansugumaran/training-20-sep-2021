package com.example.demoSpringAOP;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Data
@Slf4j
@Component
public class CurrentAccount implements BankAccount {

    private double balance;

    @Override
    public void deposit(double amount) { //joinponts
        balance += amount;
    }

    @Override
    public void withdraw(double amount) { //joinponts
        balance -= amount;
    }
}
