package com.ibm.exam.repository.impl;

import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Repository;

import com.ibm.exam.model.Employee;
import com.ibm.exam.repository.EmployeeRepository;

/**
 * "Las cuatro palabras más bonitas de nuestro idioma: ya te lo dije"
 * 
 * @author JMA
 *
 */
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	private List<Employee> employees;

	public EmployeeRepositoryImpl(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public List<Employee> findAll() {
		return employees;
	}

	@Override
	public Employee save(Employee employee) {
		ListIterator<Employee> listIterator = employees.listIterator();
		while (listIterator.hasNext()) {
			if (listIterator.next().getId().equals(employee.getId())) {
				listIterator.set(employee);
				return employee;
			}
		}
		employees.add(employee);
		return employee;
	}

}
