package com.EmployeeDirectory.EmployeeDirectory.Controller;

import com.EmployeeDirectory.EmployeeDirectory.DAO.EmployeeDAO;
import com.EmployeeDirectory.EmployeeDirectory.Entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    //Define field
    private EmployeeDAO employeeDAO;

    //Quick and dirty: inject employee dao
    public EmployeeRestController(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }

    //Expose "/employees" endpoint and return a list of all employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }
}
