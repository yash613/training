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


    @PostMapping("/employee")
    public String saveEmployee(@RequestBody Employee employee){
    return  employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/employee/{empid}")
    public String deleteEmployee(@PathVariable("empid") String empid){
        return employeeService.deleteEmployee(empid);
    }

    @PutMapping("/employee/{empid}")
    public String updateEmployee(@PathVariable("empid") String empid,@RequestBody Employee employee){
        return employeeService.updateEmployee(empid,employee);
    }



    @GetMapping("employee/{age}")
    public ResponseEntity findAllByAge(@PathVariable("age") int age){
        return ResponseEntity.ok(employeeService.findAllByAge(age));
    }

}
