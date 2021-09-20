package com.example.demoSpringWeb;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator implements HealthIndicator {


    @Override
    public Health health() {

        if( 1== 1) {
            return Health.up().withDetail("is 1==1", "yes").build();
        }
        return null;
    }
}
