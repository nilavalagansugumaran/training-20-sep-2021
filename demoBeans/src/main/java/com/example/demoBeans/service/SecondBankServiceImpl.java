package com.example.demoBeans.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SecondBankServiceImpl implements BankService {

    @Override
    public void deposit() {
        log.info("SecondBankServiceImpl - deposit()");
    }
}
