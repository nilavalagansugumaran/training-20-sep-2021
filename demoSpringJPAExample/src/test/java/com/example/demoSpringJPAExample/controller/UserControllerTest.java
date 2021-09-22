package com.example.demoSpringJPAExample.controller;

import com.example.demoSpringJPAExample.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class UserControllerTest {

    @Autowired
    UserRepository repository;

    @Autowired
    TestRestTemplate restTemplate;

    @BeforeEach
    void cleenup(){
        repository.deleteAll();
    }

    @Test
    void test_non_existing_user(){

       ResponseEntity<String> response = restTemplate.exchange("/user/123",
               HttpMethod.GET, null, String.class );
       Assertions.assertEquals(404, response.getStatusCodeValue());
        Assertions.assertTrue(repository.count() ==0);
    }

    @Test
    void test_creation_of_user(){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/json");
        HttpEntity entity = new HttpEntity("{\"name\": \"nila\" }",headers);
        ResponseEntity<String> response = restTemplate.exchange("/user",
                HttpMethod.POST, entity, String.class );
        Assertions.assertEquals(201, response.getStatusCodeValue());
       log.info("Count in repo {}",repository.count());
        Assertions.assertTrue(repository.count() ==1);

    }
}