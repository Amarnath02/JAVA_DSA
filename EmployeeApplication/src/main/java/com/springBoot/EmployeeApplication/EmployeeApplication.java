package com.springBoot.EmployeeApplication;

import com.springBoot.EmployeeApplication.model.Address;
import com.springBoot.EmployeeApplication.model.Employee;
import com.springBoot.EmployeeApplication.model.Project;
import com.springBoot.EmployeeApplication.model.Spouse;
import com.springBoot.EmployeeApplication.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate(EmployeeService employeeService) {
		return (args) -> {

			Address address1 = new Address("line1", "line2", "pinCode", "city", "state", "country");
			Project project1 = new Project("name1", "client name1");
			Spouse spouse1 = new Spouse("name1", "mobile1", 28);

			Employee employee = new Employee("employee1", "employeeCity1");
			employee.addProject(project1);
			employee.addAddress(address1);
			employee.setSpouse(spouse1);

			employeeService.createEmployee(employee);

			System.out.println("Getting an employee");
			Employee employee1 = employeeService.findEmployeeById(1L);
		};
	}

}
