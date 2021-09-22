package com.example.demoSpringJMSActiveMQ;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SenderComponent {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendGreeting(){
        log.info("Sending greeting starts...");
        jmsTemplate.convertAndSend("greetings", "Hello there...");
        log.info("Sending greeting finishes...");
    }

    public void sendUserData() {
        log.info("Sending user data starts...");
        jmsTemplate.convertAndSend("userinfo", User.builder().id(123).name("nila").build());
        log.info("Sending user data finishes...");
    }
}
