package com.example.demoSpringRestService.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Data
@AllArgsConstructor
public class Employee {

    private long id;
    private String name;
    private double salary;
}
