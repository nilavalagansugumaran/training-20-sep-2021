package com.example.demoSpringJMSActiveMQ;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReceiverComponent {

    @JmsListener(destination = "greetings")
    public void receiveGreeting(String message) {

        log.info("Receive greetings starts...");
        log.info("Message received - {}", message);
        log.info("Received greeting Complete...");
    }

    @JmsListener(destination = "userinfo")
    public void receiveUserData(User message) {

        log.info("Receive user data starts...");
        log.info("Message received - {}", message);
        log.info("Received user data Complete...");
    }
}
