package com.example.demoSpringAOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MyAspect { // aspect

    @Before("execution(void depo*(*))") // pointcut expression
    public void handleDeposits(JoinPoint jp){

        log.info("Deposit started"); // Advice
        double amount = (Double)jp.getArgs()[0];
        log.info("deposit amount = {}", amount);
        if(jp.getTarget() instanceof CurrentAccount) {
            CurrentAccount ca = (CurrentAccount) jp.getTarget();
            log.info("current balance is {}",ca.getBalance());
        }
    }

    @After("execution(void withdr*(..))") // pointcut expression
    public void handleWithdraws(JoinPoint jp){

        log.info("Withdrawal started"); // Advice
        double amount = (Double)jp.getArgs()[0];
        log.info("Withdrawal amount = {}", amount);
        if(jp.getTarget() instanceof CurrentAccount) {
            CurrentAccount ca = (CurrentAccount) jp.getTarget();
            log.info("current balance is {}",ca.getBalance());
        }
    }
}
