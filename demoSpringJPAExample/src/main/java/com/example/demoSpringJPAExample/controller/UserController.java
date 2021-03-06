package com.example.demoSpringJPAExample.controller;

import com.example.demoSpringJPAExample.models.User;
import com.example.demoSpringJPAExample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping(path ="/user")
    public User getUserByName(@RequestParam("name") String name){
        return repository.findByName(name).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    @GetMapping(path ="/user/{id}")
    public User getUser(@PathVariable("id") Long id){
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    @PostMapping(path ="/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@Valid @RequestBody User user){
        return repository.save(user);
    }

    @DeleteMapping(path ="/user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") Long id){
        getUser(id);
        repository.deleteById(id);
    }

    @PutMapping(path ="/user/{id}")
    public void updateUser(@PathVariable("id") Long id, @Valid @RequestBody User user){
        User userFromDB = getUser(id);
        userFromDB.setName(user.getName());
        repository.save(userFromDB);

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgException(MethodArgumentNotValidException exception){
        Map<String,String> errorMap = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorMap.put(fieldName, errorMessage);
        });
        return errorMap;
    }
}
