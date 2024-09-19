package com.springBoot.EmployeeApplication.repository;

import com.springBoot.EmployeeApplication.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
