package com.example.demoSpringJMSRabbitMQ;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SenderComponent {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendUserData() {
        log.info("Sending user data starts...");
        rabbitTemplate.convertAndSend("ex.nila.exchange",
                "k.nila.key",
                User.builder().id(123).name("nila").build(),
                message -> {
                    message.getMessageProperties().setHeader("myheader", "header value");
                    return message;
                });
        log.info("Sending user data finishes...");
    }
}
