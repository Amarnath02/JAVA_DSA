package com.springBoot.EmployeeApplication.service;

import com.springBoot.EmployeeApplication.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployee();
    Employee getEmployeeById(Long employeeId);
    void createEmployee(Employee employee);
    String deleteEmployee(Long employeeId);
    Employee updateEmployee(Employee employee, Long employeeId);

}
