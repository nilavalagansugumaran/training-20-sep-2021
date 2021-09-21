package com.example.demoSpringRestService.repository;

import com.example.demoSpringRestService.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;

//@Repository - Enable this if you want to run with JDBC
public class EmployeeJDBCRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Employee readEmployee(Long id){

        try {
            String sql = "select * from EMPLOYEES where id=?";
            return jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), id);
        }catch (DataAccessException e) {

        }
        return null;
    }

    public Employee readEmployeeByName(String name){

        try {
            String sql = "select * from EMPLOYEES where name=?";
            return jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), name);
        }catch (DataAccessException e) {

        }
        return null;
    }

    public Employee createEmployee(Employee e){

        jdbcTemplate.update("insert into EMPLOYEES (name, salary) values (?, ?)", new Object[] {e.getName(), e.getSalary()});
        return readEmployeeByName(e.getName());
    }

    public static class EmployeeRowMapper implements RowMapper<Employee> {

        @Override
        public Employee mapRow(ResultSet resultSet, int i) throws SQLException {

            Employee employee = new Employee();
            employee.setId(resultSet.getInt("id"));
            employee.setName(resultSet.getString("name"));
            employee.setSalary(resultSet.getDouble("salary"));
            return employee;
        }
    }

    @PostConstruct
    public void setupdb(){

        jdbcTemplate.execute("create table EMPLOYEES(id int auto_increment, name varchar(50), salary double, primary key (id) )");
        jdbcTemplate.update("insert into EMPLOYEES (name, salary) values (?, ?)", new Object[] {"nila-1", 2000});
        jdbcTemplate.update("insert into EMPLOYEES (name, salary) values (?, ?)", new Object[] {"nila-2", 2500});
        jdbcTemplate.update("insert into EMPLOYEES (name, salary) values (?, ?)", new Object[] {"nila-3", 3000});
    }
}
