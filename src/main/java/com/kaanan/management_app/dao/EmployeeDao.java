package com.kaanan.management_app.dao;

import com.kaanan.management_app.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface EmployeeDao {
    Employee save(Employee employee);
    Optional<Employee> findByEmployeeId(int employeeId);
    List<Employee> findAll();
    Employee update(Employee employee);
    void delete(int employeeId);
}
