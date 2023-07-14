package com.EmployeeDirectory.EmployeeDirectory.Controller;

import com.EmployeeDirectory.EmployeeDirectory.Entity.Employee;
import com.EmployeeDirectory.EmployeeDirectory.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    //Expose "/employees" endpoint and return a list of all employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    //Add mapping for GET /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee == null){
            throw new RuntimeException("Employee " + employeeId + " not found.");
        }
        return theEmployee;
    }

    //Add mapping for POST /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //In the event the user passes in an ID in JSON, set the ID to 0.
        // This will force a save of a new item instead of an update.

        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    //Add mapping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

//    Add mapping for DELETE /employees/{employeeId} - delete existing employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        //Find the employee by their id
        Employee employeeToDelete = employeeService.findById(employeeId);

        //Check to see if the employee exist in the database
        if(employeeToDelete == null){
            throw new RuntimeException("Employee " + employeeId + " was not found.");
        }

        //Delete employee
        employeeService.deleteById(employeeId);

        //Return a message
        return "Employee " + employeeId + " was successfully deleted." ;

    }

}
