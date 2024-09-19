package com.springBoot.EmployeeSystem.controller;

import com.springBoot.EmployeeSystem.entity.Employee;
import com.springBoot.EmployeeSystem.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/addEmp")
    public String addEmployee() {
        return "addEmp";
    }

    @PostMapping("/register")
    public String employeeRegister(@ModelAttribute Employee employee,
                                   HttpSession session) {
        System.out.println(employee);

        employeeService.addEmployee(employee);
        session.setAttribute("msg", "Employee Added Successfully!");

        return "redirect:/";
    }
}
