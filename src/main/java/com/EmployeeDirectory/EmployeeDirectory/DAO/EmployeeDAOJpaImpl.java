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
}
