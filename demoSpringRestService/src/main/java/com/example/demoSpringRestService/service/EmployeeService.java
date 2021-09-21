package com.example.demoSpringRestService.service;

import com.example.demoSpringRestService.model.Employee;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class EmployeeService {

    private ConcurrentHashMap<Long, Employee> mockDB = new ConcurrentHashMap<>();

    public Employee getEmployee(){
        return mockDB.get(101L);
    }

    @PostConstruct
    public void intData(){
        mockDB.put(101L, new Employee(101,"nila-101", 2000.0d));
        mockDB.put(102L, new Employee(102,"nila-102", 3000.0d));
        mockDB.put(103L, new Employee(103,"nila-103", 4000.0d));
    }
}
