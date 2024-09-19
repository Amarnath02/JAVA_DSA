package com.springBoot.EmployeeApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String line1;
    private String line2;
    private String pinCode;
    private String city;
    private String state;
    private String country;

    @JsonIgnore // ignore many address not come
    @ManyToOne
    private Employee employee;

    public Address(String line1, String line2, String pinCode, String city, String state, String country) {
        this.line1 = line1;
        this.line2 = line2;
        this.pinCode = pinCode;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Address(String line1, String line2, String pinCode, String city, String state, String country, Employee employee) {
        this.line1 = line1;
        this.line2 = line2;
        this.pinCode = pinCode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.employee = employee;
    }

    public Address() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
