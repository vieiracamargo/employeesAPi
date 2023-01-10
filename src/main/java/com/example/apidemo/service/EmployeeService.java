package com.example.apidemo.service;

import com.example.apidemo.entity.Employee;
import com.example.apidemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
    }

    public Employee updateEmployee(Long emId, Employee employeeDetails) {
        Employee emp = employeeRepository.findById(emId).get();
        emp.setFirstName(employeeDetails.getFirstName());
        emp.setLastName(employeeDetails.getLastName());
        emp.setEmailId(employeeDetails.getEmailId());

        return employeeRepository.save(emp);
    }
}
