package com.nagp.kubernetes.rest.controller;

import com.nagp.kubernetes.persistence.dao.EmployeeRepository;
import com.nagp.kubernetes.persistence.entity.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> getAllEmployeeData() {
        return employeeRepository.findAll();
    }

    @PostMapping
    public List<Employee> addEmployeeData(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return employeeRepository.findAll();
    }

    @DeleteMapping
    public List<Employee> deleteEmployeeData(@RequestParam(name = "id") long employeeId){
        employeeRepository.deleteById(employeeId);
        return employeeRepository.findAll();
    }
}
