package com.EmployeeDirectory.EmployeeDirectory.Controller;

import com.EmployeeDirectory.EmployeeDirectory.Entity.Employee;
import com.EmployeeDirectory.EmployeeDirectory.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    //Wire in the Employee Service
    private EmployeeService employeeService;

    //Constructor injection
    @Autowired
    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // Add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        //Create a list of all the employees in the DB
        List<Employee> theEmployees = employeeService.findAll();

        //Add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees";
    }

    @GetMapping("/addEmployee")
    public String addEmployeeForm(Model theModel){
        //Create a model attribute to bind the form data
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }

    @GetMapping("/updateEmployee")
    public String updateEmployeeForm(@RequestParam("employeeId") int theId, Model theModel){
        //Get the employee from the Employee Service
        Employee theEmployee = employeeService.findById(theId);

        //Set the employee in the model to pre-populate the form with that employee's information
        theModel.addAttribute("employee", theEmployee);

        //Send the information to the form

        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId){
        //Delete the employee
        employeeService.deleteById(theId);

        //Redirect to the employees/list
        return "redirect:/employees/list";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
        //Save the employee
        employeeService.save(theEmployee);

        //Use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }


}
