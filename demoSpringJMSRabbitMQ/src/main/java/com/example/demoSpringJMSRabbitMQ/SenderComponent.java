package com.example.demoSpringJMSRabbitMQ;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SenderComponent {

    public void sendUserData() {
        log.info("Sending user data starts...");

        log.info("Sending user data finishes...");
    }
}
