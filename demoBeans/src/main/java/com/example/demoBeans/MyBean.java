package com.example.demoBeans;

import com.example.demoBeans.service.BankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype") //prototype , request, session, websocket
@Slf4j
public class MyBean {

    @Autowired //(required = false) - for optionality
    @Qualifier("secondBankServiceImpl")
    //private List<BankService> service;
    private BankService service;

    public void doSomething(){
       // System.out.println("This is from MyBean");
        log.info("This is from MyBean");
//        service.stream().forEach(s -> {
//            s.deposit();
//        });
        service.deposit();
    }
}
