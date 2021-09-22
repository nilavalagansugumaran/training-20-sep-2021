package com.example.demoSpringJMSRabbitMQ;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRabbitConfig {

    // create a message converter
    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
    // create a queue
    @Bean
    public Queue queue(){
        return QueueBuilder.durable("q.nila.queue").build();
    }
    // create an exchange
    @Bean
    public Exchange exchange(){
        return ExchangeBuilder.directExchange("ex.nila.exchange").build();
    }
    // bind both queue and exchange
    @Bean
    public Binding binding(Queue q, Exchange e){
        return BindingBuilder.bind(q).to(e).with("k.nila.key").noargs();
    }
}
