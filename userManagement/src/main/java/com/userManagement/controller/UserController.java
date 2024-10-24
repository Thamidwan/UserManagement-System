package com.userManagement.controller;

import com.userManagement.model.Employee;
import com.userManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/index")
    public String landing(){
        return "index";
    }

    @RequestMapping("/view_users")
    public String viewUsers(){
        return "view_users";
    }

    @RequestMapping("/add_user")
    public String addUser(){
        return "add_user";
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee createEmployee = employeeService.createEmployee(employee);
        return  new ResponseEntity<>(createEmployee, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

}
