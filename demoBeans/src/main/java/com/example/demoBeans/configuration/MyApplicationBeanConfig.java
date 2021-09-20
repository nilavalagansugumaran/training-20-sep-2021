package com.example.demoBeans.configuration;

import com.example.demoBeans.MyBean2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyApplicationBeanConfig {

    @Bean
    public MyBean2 myOtherBean(){

        return new MyBean2();
    }

    @Bean
    public MyBean2 myOtherBean1(){

        return new MyBean2();
    }
}
