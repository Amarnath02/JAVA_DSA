package com.springBoot.EmployeeApplication.service;

import com.springBoot.EmployeeApplication.model.Address;
import com.springBoot.EmployeeApplication.model.Employee;
import com.springBoot.EmployeeApplication.model.Project;
import com.springBoot.EmployeeApplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService{

//    List<Employee> employeeList = new ArrayList<>();
    @Autowired
    public EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee Not Found"));

        System.out.println("Fetching projects");
        Set<Project> projects = employee.getProjects();
        for (Project p : projects) {
            System.out.println(p.getClientName());
        }

        return employee;
    }

    @Override
    public void createEmployee(Employee employee) {
        ArrayList<Address> addresses = new ArrayList<>();

        for (Address address : employee.getAddresses()) {
            addresses.add((new Address(address.getLine1(),
                    address.getLine2(), address.getPinCode(),
                    address.getCity(), address.getState(),
                    address.getCountry(), employee)));
        }
        employee.setAddresses(addresses);

        employeeRepository.save(employee);
    }

    @Override
    public String deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found"));

        employeeRepository.delete(employee);
        return "Employee with Employee Id: " + employeeId + " deleted successfully";
    }

    @Override
    public Employee updateEmployee(Employee employee, Long employeeId) {

        Employee employee1 = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found"));

        employee.setEmployeeId(employeeId);
        employee1 = employeeRepository.save(employee);

        return employee1;

    }
}
