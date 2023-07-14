package com.EmployeeDirectory.EmployeeDirectory.DAO;

import com.EmployeeDirectory.EmployeeDirectory.Entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    //Define field for entityManager
    private EntityManager entityManager;

    //Set up constructor injection

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        //Create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);

        //Execute query and get results list
        List<Employee> employees = theQuery.getResultList();

        //Return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        //Get the employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

        //Return the employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        //Save the employee
        Employee dbEmployee = entityManager.merge(theEmployee); //The way this merge method works here is that, it'll perform a save or update, depending on the actual ID of the entity. If the ID of the entity is equal to zero, then it'll actually save or insert that given entity, into the database. So that's like a new entry there, else, if the idea is not equal to zero, it'll simply perform an update. Okay, so effectively here if ID is zero, it's going to be an insert, else it'll be an update. And this method will return the updated employee.

        //Return the employee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        //Find employee by ID
        Employee theEmployee = entityManager.find(Employee.class, theId);

        //Remove the employee
        entityManager.remove(theEmployee);
    }
}
