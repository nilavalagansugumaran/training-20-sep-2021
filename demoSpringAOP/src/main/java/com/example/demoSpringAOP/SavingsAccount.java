package com.example.demoSpringAOP;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Data
public class SavingsAccount implements BankAccount {

    @Autowired
    private BankRepository bankRepository;

    private double balance;

    @Override
    public void deposit(double amount) { //joinpoints
        balance += amount;
        bankRepository.save();
    }

    @Override
    public void withdraw(double amount) { //joinponts
        balance -= amount;
        bankRepository.save();
    }
}
