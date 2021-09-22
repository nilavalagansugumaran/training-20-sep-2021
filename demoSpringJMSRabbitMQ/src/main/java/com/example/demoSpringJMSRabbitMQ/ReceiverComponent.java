package com.example.demoSpringJMSRabbitMQ;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReceiverComponent {


    public void receiveUserData(User message) {

        log.info("Receive user data starts...");
        log.info("Received user data Complete...");
    }
}
