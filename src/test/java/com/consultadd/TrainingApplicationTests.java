package com.consultadd;
import com.consultadd.model.Employee;
import static org.junit.Assert.*;
import com.consultadd.repository.EmployeeRepository;
import com.consultadd.service.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TrainingApplicationTests {

	@Mock
	EmployeeRepository employeeRepository;
	@InjectMocks
	EmployeeService employeeService;
	public List<Employee> employeeList;

	@Test
	public void getUserTest(){
		List<Employee> employeeList=new ArrayList<Employee>();
		Employee emp1=new Employee("1","yash",27);
		Employee emp2=new Employee("2","ritik",23);
		employeeList.add(emp1);
		employeeList.add(emp2);


		Mockito.when(employeeRepository.findAll()).thenReturn(employeeList);
		assertEquals(2,employeeService.getEmployees().size());
	}
	@Test
	 public void findAllByAgeTest(){

		 List<Employee> employeeList=new ArrayList<Employee>();
		 Employee emp1=new Employee("1","yash",27);
		 Employee emp2=new Employee("2","ritik",23);

		 employeeList.add(emp1);
		 employeeList.add(emp2);
		int age=23;

//		 Mockito.when(employeeRepository.findAllByAge(age)).thenReturn(employeeList);
//		 assertEquals(employeeList,employeeService.findAllByAge(age));
		Mockito.when(employeeRepository.findAllByAge(age)).thenReturn(employeeList);
		assertEquals(age,employeeService.findAllByAge(age).get(1).getAge());

	 }


	@Test
	public  void  test_saveEmployee(){

		Employee emp1=new Employee("1","yash",27);

		Mockito.when(employeeRepository.save(emp1)).thenReturn(emp1);

		assertEquals("data saved successfully",employeeService.saveEmployee(emp1));

	}

//	@Test
//	public  void test_deleteEmployee(){
//		Employee emp1=new Employee("1","yash",27);
//
//		employeeService.deleteEmployee(emp1.getId());
//
//		Mockito.verify(employeeRepository,Mockito.times(1)).deleteById(emp1.getId());
//
//	}
}
