package com.example.demoSpringAOP;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CurrentAccountTest {

    @Autowired
    private CurrentAccount currentAccount;

    @BeforeEach
    void cleanup(){
        currentAccount.setBalance(0);
    }

    @Test
    void test_deposit(){

        currentAccount.deposit(100);
        Assertions.assertEquals(100, currentAccount.getBalance());
    }

    @Test
    void test_withdraw(){

        currentAccount.withdraw(25);
        Assertions.assertEquals(75, currentAccount.getBalance());
    }

}