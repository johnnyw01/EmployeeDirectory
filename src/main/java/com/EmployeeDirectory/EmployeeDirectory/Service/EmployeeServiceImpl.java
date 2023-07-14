package com.EmployeeDirectory.EmployeeDirectory.Service;

import com.EmployeeDirectory.EmployeeDirectory.DAO.EmployeeRepository;
import com.EmployeeDirectory.EmployeeDirectory.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        //instead of having a right code to check for nulls, you can make use of Optional to see if a given value is present.

        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if(result.isPresent()){
            theEmployee = result.get();
        }else{
            //Could not find the queried employee in the database
            throw new RuntimeException("Could not find employee " + theId);
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }
    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
