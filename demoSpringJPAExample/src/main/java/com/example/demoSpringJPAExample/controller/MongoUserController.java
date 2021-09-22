package com.example.demoSpringJPAExample.controller;

import com.example.demoSpringJPAExample.models.MongoUser;
import com.example.demoSpringJPAExample.models.User;
import com.example.demoSpringJPAExample.repository.MongoUserRepository;
import com.example.demoSpringJPAExample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class MongoUserController {

    @Autowired
    private MongoUserRepository repository;

    @GetMapping(path ="/mongouser")
    public MongoUser getUserByName(@RequestParam("name") String name){
        return repository.findByName(name).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    @GetMapping(path ="/mongouser/{id}")
    public MongoUser getUser(@PathVariable("id") String id){
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    @PostMapping(path ="/mongouser")
    @ResponseStatus(HttpStatus.CREATED)
    public MongoUser createUser(@RequestBody MongoUser user){
        try{
           MongoUser mongoUser =  getUserByName(user.getName());
           if(mongoUser != null) {
               throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "user already exist");
           }
        } catch (ResponseStatusException e){
        }
        return repository.save(user);
    }

    @DeleteMapping(path ="/mongouser/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") String id){
        getUser(id);
        repository.deleteById(id);
    }

    @PutMapping(path ="/mongouser/{id}")
    public void updateUser(@PathVariable("id") String id, @RequestBody MongoUser user){
        MongoUser userFromDB = getUser(id);
        userFromDB.setName(user.getName());
        repository.save(userFromDB);

    }
}
