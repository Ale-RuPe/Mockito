package com.ibm.exam.repository;

import java.util.List;

import com.ibm.exam.model.Employee;

/**
 * "Un día sin sol es, ya sabes, de noche"
 * 
 * @author JMA
 *
 */
public interface EmployeeRepository {

	List<Employee> findAll();

	Employee save(Employee e);
}
