package com.example.demoSpringRestService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MySampleController {

    @GetMapping(path = "/hello")
    public String sayHello(){

        return "Hello!!";
    }
}
