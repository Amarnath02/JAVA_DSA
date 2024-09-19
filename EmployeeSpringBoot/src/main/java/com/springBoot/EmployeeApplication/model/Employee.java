package com.springBoot.EmployeeApplication.model;

import jakarta.persistence.Entity;

@Entity
public class Employee {

    private Long employeeId;
    private String employeeName;
    private String city;

    public Employee(Long employeeId, String employeeName, String city) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.city = city;
    }

    public Employee() {

    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
