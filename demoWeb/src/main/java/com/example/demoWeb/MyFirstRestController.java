package com.example.demoWeb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstRestController {

    @GetMapping(path = "/hello")
    public String sayHello(@RequestParam String name){

        return "Hello " +name+  "!!!";
    }
}
