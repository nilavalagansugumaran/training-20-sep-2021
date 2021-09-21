package com.example.demoSpringRestService.controller;

import com.example.demoSpringRestService.model.Employee;
import com.example.demoSpringRestService.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    @GetMapping(path = "/employee", headers = {"Accept=application/json, application/xml",
//            "Content-Type=application/json, application/xml"})
//    public Employee getEmployee(){
//        return employeeService.getEmployee();
//    }

    @GetMapping(path="/employee", headers = {"Accept=application/json, application/xml",
            "Content-Type=application/json, application/xml"})
    public Employee getEmployee(@RequestParam("id") Long id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping(path="/employee", headers = {"Accept=application/json, application/xml",
            "Content-Type=application/json, application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping(path="/employee/{id}", headers = {"Accept=application/json, application/xml",
            "Content-Type=application/json, application/xml"})
    public void updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping(path="/employee/{id}", headers = {"Accept=application/json, application/xml",
            "Content-Type=application/json, application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
    }

    @DeleteMapping(path="/employees", headers = {"Accept=application/json, application/xml",
            "Content-Type=application/json, application/xml"})
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
}
