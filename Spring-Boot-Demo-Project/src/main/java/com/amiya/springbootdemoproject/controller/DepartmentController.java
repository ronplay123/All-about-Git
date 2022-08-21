package com.amiya.springbootdemoproject.controller;

import com.amiya.springbootdemoproject.entity.Department;
import com.amiya.springbootdemoproject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired private DepartmentService departmentService;

      @PostMapping("/departments")
    public Department saveDepartment(
            @Validated @RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }
     @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        return departmentService.fetchDepartmentList();
    }
    @PutMapping("/departments/{id}")
    public Department
    updateDepartment(@RequestBody Department department,
                 @PathVariable("id") Long departmentId) {
    return departmentService.updateDepartment(
            department, departmentId);
}
@DeleteMapping("/departments/{id}")
public String deleteDepartmentById(@PathVariable("id")Long departmentId) {
    departmentService.deleteDepartmentById(departmentId);
    return "Delete Successfully";
}
}