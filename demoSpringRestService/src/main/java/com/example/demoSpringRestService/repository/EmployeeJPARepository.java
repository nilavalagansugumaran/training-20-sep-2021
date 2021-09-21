package com.example.demoSpringRestService.repository;

import com.example.demoSpringRestService.model.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository // enable this if you want to run with entity manager
public class EmployeeJPARepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Employee readEmployee(Long id){
        return entityManager.find(Employee.class, id);
    }

    public Employee readEmployeebYName(String name){
        String sql = "select e from Employee e where name='"+name+"'";
        TypedQuery<Employee> employeeTypedQuery = entityManager.createQuery(sql, Employee.class);
        return employeeTypedQuery.getSingleResult();
    }

    @Transactional
    public Employee createEmployee(Employee employee){
        entityManager.persist(employee);
        return readEmployeebYName(employee.getName());
    }
}
