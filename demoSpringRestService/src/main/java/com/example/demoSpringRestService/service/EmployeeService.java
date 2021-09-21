package com.example.demoSpringRestService.service;

import com.example.demoSpringRestService.model.Employee;
import com.example.demoSpringRestService.repository.EmployeeJDBCRepository;
import com.example.demoSpringRestService.repository.EmployeeJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

//    @Autowired
//    private EmployeeJDBCRepository repository;

    @Autowired
    private EmployeeJPARepository repository;

    private ConcurrentHashMap<Long, Employee> mockDB = new ConcurrentHashMap<>();

    public List<Employee> getAllEmployees(){
        return mockDB.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }

    public Employee getEmployee(Long id){
//        if( mockDB.containsKey(id)) {
//                return mockDB.get(id);
//        }
        Employee employee = repository.readEmployee(id);
        if(employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        } else {
            return employee;
        }
    }

    public Employee createEmployee(Employee e) {
//        mockDB.putIfAbsent(e.getId(), e);
//        return e;

       return repository.createEmployee(e);
    }

    public void deleteEmployee(Long id) {
        getEmployee(id);
        mockDB.remove(id);
    }

    public void updateEmployee(Long id, Employee e) {
        getEmployee(id);
        mockDB.put(id, e);
    }

    @PostConstruct
    public void intData(){
        mockDB.put(101L, new Employee(101,"nila-101", 2000.0d));
        mockDB.put(102L, new Employee(102,"nila-102", 3000.0d));
        mockDB.put(103L, new Employee(103,"nila-103", 4000.0d));
    }
}
