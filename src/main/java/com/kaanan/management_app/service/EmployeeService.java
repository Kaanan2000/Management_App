package com.kaanan.management_app.service;

import com.kaanan.management_app.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    Employee findEmployeeById(int id);
    List<Employee> findAllEmployee();
    Employee updateEmployee(Employee employee);
    void deleteEmployee(int id);
}
