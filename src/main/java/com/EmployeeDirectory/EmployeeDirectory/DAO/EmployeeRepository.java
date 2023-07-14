package com.EmployeeDirectory.EmployeeDirectory.DAO;

import com.EmployeeDirectory.EmployeeDirectory.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //No need to write any addition code or an implementation class. The JPA Repository has all the methods pre-defined that we need for basic CRUD functionality
}
