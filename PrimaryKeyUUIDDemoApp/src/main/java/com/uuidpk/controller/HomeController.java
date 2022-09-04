package com.uuidpk.controller;


import com.uuidpk.model.Employee;
import com.uuidpk.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @PostMapping("/save")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return new ResponseEntity<Employee>(HttpStatus.OK);
    }
    @GetMapping("/allEmployees")
    public List<Employee>getAllEmployees() {
        List<Employee> allEmployees = employeeRepository.findAll();
        return allEmployees;
    }
    @GetMapping("/")
public String welcomePage() {
        return "welcome";
}

}




