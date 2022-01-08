package com.consultadd.repository;

import com.consultadd.model.Employee;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Query(value = "Select * from Employee  where age = :age",nativeQuery = true)
    List<Employee> findAllByAge(int age);
}
