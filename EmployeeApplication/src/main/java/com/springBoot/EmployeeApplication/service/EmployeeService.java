package com.springBoot.EmployeeApplication.service;

import com.springBoot.EmployeeApplication.model.Employee;
import jdk.jfr.Category;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployee();
    Employee findEmployeeById(Long employeeId);
    void createEmployee(Employee employee);
    String deleteEmployee(Long employeeId);
    Employee updateEmployee(Employee employee, Long employeeId);
}
