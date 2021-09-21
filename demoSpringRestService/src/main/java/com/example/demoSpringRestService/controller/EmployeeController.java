package com.example.demoSpringRestService.controller;

import com.example.demoSpringRestService.model.Employee;
import com.example.demoSpringRestService.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/employee", headers = {"Accept=application/json, application/xml",
            "Content-Type=application/json, application/xml"})
    public Employee getEmployee(){
        return employeeService.getEmployee();
    }
}
