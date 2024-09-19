package com.springBoot.EmployeeApplication.service;

import com.springBoot.EmployeeApplication.model.Employee;
import com.springBoot.EmployeeApplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        Employee employee1 = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Not Found"));

        return employeeRepository.save(employee1);
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public String deleteEmployee(Long employeeId) {
        Employee employee1 = employeeRepository.findById(employeeId)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Not Found"));

        employeeRepository.delete(employee1);
        return "Employee with employee Id : " + employeeId + " is deleted successfully";
    }

    @Override
    public Employee updateEmployee(Employee employee, Long employeeId) {
        Employee employee2 = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Not Found"));

        employee.setEmployeeId(employeeId);
        employee2 = employeeRepository.save(employee);
        return employee2;
    }
}
