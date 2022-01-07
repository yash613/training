package com.consultadd.controller;

import com.consultadd.model.Employee;
import com.consultadd.repository.EmployeeRepository;
import com.consultadd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// controller -> service -> repository

@RestController
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }


    @PostMapping("/addemp")
    public String saveEmployee(@RequestBody Employee employee){
    return  employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/emp/{empid}")
    public String deleteEmployee(@PathVariable("empid") String empid){
        return employeeService.deleteEmployee(empid);
    }

    @PutMapping("/employee")
    public String updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

}
