package com.consultadd.service;

import com.consultadd.model.Employee;
import com.consultadd.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(){
            return employeeRepository.findAll();
    }


    public  String saveEmployee(Employee employee){
        if(employeeRepository.existsById(employee.getId())) {
            return "couldn't save data ,id already exist";
        }
            else{
                employeeRepository.save(employee);
                return "data saved successfully";
            }

    }
    public String deleteEmployee(String id){
        if(employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return "Data Deleted succesfully";
        }
        else
            return "the given id does not exist";
    }
    public  String updateEmployee(String id,Employee employee){
        if(employeeRepository.existsById(id)) {
            employeeRepository.save(employee);
            return "data Updated successfully";
        }
        else{

            return "couldn't save data ,id doesn't exist";
        }

    }


}
