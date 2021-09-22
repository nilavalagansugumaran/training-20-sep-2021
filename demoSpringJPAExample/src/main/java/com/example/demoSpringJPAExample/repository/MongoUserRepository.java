package com.example.demoSpringJPAExample.repository;

import com.example.demoSpringJPAExample.models.MongoUser;
import com.example.demoSpringJPAExample.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MongoUserRepository extends MongoRepository<MongoUser, String> {
    Optional<MongoUser> findByName(String name);
}
