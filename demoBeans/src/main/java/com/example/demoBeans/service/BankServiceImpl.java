package com.example.demoBeans.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BankServiceImpl implements BankService {

    @Override
    public void deposit() {
        log.info("deposit()");
    }
}
