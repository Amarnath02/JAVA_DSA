package com.springBoot.EmployeeApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String employeeName;
    private String employeeCity;

//    @OneToOne(cascade = CascadeType.ALL)
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "fk_spouse") // foreign key name modify
    private Spouse spouse;

//    @OneToMany(cascade = CascadeType.ALL)
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Address> addresses;

//    @ManyToMany(cascade = CascadeType.ALL)
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinTable(name = "employee_project",
        joinColumns = @JoinColumn(name = "fk_employee"),
        inverseJoinColumns = @JoinColumn(name = "fk_project"))
    private Set<Project> projects = new HashSet<>();

    public Employee(Long employeeId, String employeeName, String employeeCity) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeCity = employeeCity;
    }

    public Employee(String employeeName, String employeeCity) {
        this.employeeName = employeeName;
        this.employeeCity = employeeCity;
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

    public String getEmployeeCity() {
        return employeeCity;
    }

    public void setEmployeeCity(String employeeCity) {
        this.employeeCity = employeeCity;
    }

    public Spouse getSpouse() {
        return spouse;
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public void removeProject(Project project) {
        this.projects.remove(project);
        project.getEmployees().remove(project);
    }

    public void addProject(Project project) {
        this.projects.add(project);
        project.getEmployees().add(this);
    }

    public void addAddress(Address address) {
        this.addresses = new ArrayList<>();
        this.addresses.add(address);
        address.setEmployee(this);
    }

    public void removeAddress(Address address) {
        this.addresses.remove(address);
        address.setEmployee(null);
    }
}
