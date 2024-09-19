package com.springBoot.EmployeeApplication.controller;

import com.springBoot.EmployeeApplication.model.Employee;
import com.springBoot.EmployeeApplication.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/public")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("employeeList")
    public ResponseEntity<List<Employee>> getEmployeeList() {
        List<Employee> employeeList = employeeService.getEmployee();

        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("employeeList/{employeeId}")
    public ResponseEntity<List<Employee>> getEmployeeById(@PathVariable Long employeeId) {
        Employee exist = employeeService.getEmployeeById(employeeId);

        List<Employee> find = Arrays.asList(exist);
        return new ResponseEntity<>(find, HttpStatus.OK);
    }

    @PostMapping("employeeList/update")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);

        return new ResponseEntity<>("Employee created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("employeeList/delete/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId) {
        try {
            String value = employeeService.deleteEmployee(employeeId);

            return new ResponseEntity<>(value, HttpStatus.OK);
        }
        catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @PutMapping("employeeList/update/{employeeId}")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee,
                                                 @PathVariable Long employeeId) {
        try {
            Employee employee1 = employeeService.updateEmployee(employee, employeeId);

            return new ResponseEntity<>("Employee with employee Id : " + employeeId + " is updated successfully",
                    HttpStatus.OK);
        }
        catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }
}
