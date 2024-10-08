package com.kaanan.management_app.controller;

import com.kaanan.management_app.model.Employee;
import com.kaanan.management_app.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@PreAuthorize("hasRole('USER')")
public class UserController {

    @Autowired
    private EmployeeServiceImpl employeeService;


    //Get an Employee By ID
    @GetMapping("/view/{id}")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
        try {
            Employee employee = employeeService.findEmployeeById(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    //Get all Employees
    @GetMapping("/view")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

}

