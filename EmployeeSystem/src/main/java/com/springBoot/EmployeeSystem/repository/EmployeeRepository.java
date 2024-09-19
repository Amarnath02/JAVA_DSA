package com.springBoot.EmployeeSystem.repository;

import com.springBoot.EmployeeSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
