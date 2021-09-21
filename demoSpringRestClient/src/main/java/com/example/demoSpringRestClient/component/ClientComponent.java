package com.example.demoSpringRestClient.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class ClientComponent {

    private RestTemplate restTemplate;

    public void callEmployeeService(){

        // set headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");

        // create entity
        HttpEntity entity = new HttpEntity("", headers);

        // call the endpoint using exchange
        ResponseEntity<String> response =
                restTemplate.exchange("http://localhost:9099/employee?id=101", HttpMethod.GET,entity, String.class);

        log.info(response.getBody());
        log.info(response.getStatusCode().toString());

        // create entity for POST
        HttpEntity entityForPost = new HttpEntity("{\"id\":110,\"name\":\"nila-110\",\"salary\":2000.0}", headers);

        // call the endpoint using exchange
        ResponseEntity<String> responseFromPost =
                restTemplate.exchange("http://localhost:9099/employee/", HttpMethod.POST,entityForPost, String.class);
        log.info(responseFromPost.getBody());
        log.info(responseFromPost.getStatusCode().toString());

    }

    @PostConstruct
    public void setup(){
        restTemplate = new RestTemplate();
    }
}
