package com.example.demoSpringWeb;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "contact")
@Data
public class Contact {

    //@Value("${contact.name}")
    private String name;
    private Address address;

    @Data
    public static class Address {
        private Long houseNumber;
        private String postcode;
    }
}
