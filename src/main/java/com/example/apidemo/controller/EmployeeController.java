package com.example.apidemo.controller;

import com.example.apidemo.entity.Employee;
import com.example.apidemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value="/employees", method = RequestMethod.POST)
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @RequestMapping(value="/employees", method=RequestMethod.GET)
    public List<Employee> readEmployees() {
        return employeeService.getEmployees();
    }

    @RequestMapping(value = "/employess/{empId}", method = RequestMethod.PUT)
    public  Employee readEmployees(@PathVariable(value = "empId") Long id, @RequestBody Employee empDetails) {
        return employeeService.updateEmployee(id, empDetails);
    }

    @RequestMapping(value ="/employees/{emId}", method = RequestMethod.DELETE)
    public void deleteEmployees(@PathVariable(value = "empId") Long id) {
        employeeService.deleteEmployee(id);
    }




}
