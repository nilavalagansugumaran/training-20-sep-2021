package com.example.demoSpringJMSRabbitMQ;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReceiverComponent {

    @RabbitListener(queues = "q.nila.queue")
    public void receiveUserData(@Payload User message, @Header(name = "myheader", required = false) String header) {
        log.info("Receive user data starts...");
        log.info("Message received... {}, header {}", message, header);
        log.info("Received user data Complete...");
    }
}
