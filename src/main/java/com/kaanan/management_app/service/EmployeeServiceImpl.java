package com.kaanan.management_app.service;

import com.kaanan.management_app.dao.EmployeeDaoImpl;
import com.kaanan.management_app.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDaoImpl employeeDao;

    @Override
    public Employee saveEmployee(Employee employee) {
        employeeDao.save(employee);
        return employee;
    }

    @Override
    public Employee findEmployeeById(int id) {
        Optional<Employee> employee = employeeDao.findByEmployeeId(id);
        return employee.orElseThrow(() -> new RuntimeException("Employee Not Found for id: " + id));
    }

    @Override
    public List<Employee> findAllEmployee() {
        return employeeDao.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        if (employeeDao.findByEmployeeId(employee.getEmployeeId()).isEmpty()) {
            throw new RuntimeException("Employee not found");
        }
        return employeeDao.update(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDao.delete(id);
    }
}
