package com.example.demoSpringJPAExample.models;

import com.example.demoSpringJPAExample.annotation.OnlyLetters;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OnlyLetters
    @Size(min = 4, max = 8, message = "Name must be between 4 and 8 chars long")
    private String name;

}
