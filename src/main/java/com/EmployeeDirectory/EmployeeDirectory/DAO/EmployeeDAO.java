package com.EmployeeDirectory.EmployeeDirectory.DAO;

import com.EmployeeDirectory.EmployeeDirectory.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
