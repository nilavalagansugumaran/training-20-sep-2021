package com.example.demoSpringAOP;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SavingsAccountTest {

    @Autowired
    SavingsAccount savingsAccount;

    @MockBean
    BankRepository bankRepository;

    @Test
    void test_repository_is_down() {
        Mockito.doThrow(new RuntimeException("repo not available")).when(bankRepository).save();

        Exception exception = assertThrows(RuntimeException.class, () -> {
            savingsAccount.deposit(100);
        });
        Assertions.assertEquals("repo not available", exception.getMessage());
    }
}