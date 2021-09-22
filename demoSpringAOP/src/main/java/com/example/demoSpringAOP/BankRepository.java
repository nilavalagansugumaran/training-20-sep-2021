package com.example.demoSpringAOP;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class BankRepository {

    public void save(){
        log.info("bank account saved");
    }
}
