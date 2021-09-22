package com.example.demoSpringAOP;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Data
public class SavingsAccount implements BankAccount {

    private double balance;

    @Override
    public void deposit(double amount) { //joinpoints
        balance += amount;
    }

    @Override
    public void withdraw(double amount) { //joinponts
        balance -= amount;
    }
}
