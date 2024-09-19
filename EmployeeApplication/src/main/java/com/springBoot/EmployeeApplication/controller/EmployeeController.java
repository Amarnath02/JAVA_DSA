package com.springBoot.EmployeeApplication.controller;

import com.springBoot.EmployeeApplication.model.Employee;
import com.springBoot.EmployeeApplication.service.EmployeeService;
import jdk.jfr.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController // Combination of @Controller and @ResponseBody
public class EmployeeController {

//    public List<Employee> employeeList = new ArrayList<>();

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("api/public/employeeList")
    public ResponseEntity<List<Employee>> findAllEmployee() {
        return new ResponseEntity<>(employeeService.findAllEmployee(), HttpStatus.OK);
    }

    @GetMapping("api/public/employeeList/{employeeId}")
    public ResponseEntity<List<Employee>> findEmployeeById(@PathVariable Long employeeId) {
        Employee exist = employeeService.findEmployeeById(employeeId);

        List<Employee> find = List.of(exist);
        return new ResponseEntity<>(find, HttpStatus.OK);
    }

    @PostMapping("api/public/employeeList")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
        return new ResponseEntity<>("Employee added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("api/admin/employeeList/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId) {
        try {
            String status = employeeService.deleteEmployee(employeeId);
            return ResponseEntity.status(HttpStatus.OK).body(status);
        }
        catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @PutMapping("api/admin/employeeList/{employeeId}")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee,
                                   @PathVariable Long employeeId) {
        try {
            Employee employee1 = employeeService.updateEmployee(employee, employeeId);

            return new ResponseEntity<>("Employee with employee Id: " + employeeId + " is updated successfully", HttpStatus.OK);
        }
        catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }
}
