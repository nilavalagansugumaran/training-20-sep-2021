package com.example.demoSpringJPAExample.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Data
public class MongoUser {

    @Id
    private String id;
    private String name;

}
