package com.ibm.exam.respository.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ibm.exam.model.Employee;
import com.ibm.exam.repository.EmployeeRepository;
import com.ibm.exam.repository.impl.EmployeeRepositoryImpl;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeRepositoryTest {
	private List<Employee> empleados;
	
	@Mock
	EmployeeRepository repo = new EmployeeRepositoryImpl(empleados);
	
	@Test
	public void findAll() {
		empleados = new ArrayList<>();
		Employee e1 = new Employee("1", 1000.00);
		Employee e2 = new Employee("2", 2000.00);
		Employee e3 = new Employee("3", 3000.00);
		empleados.add(e1);
		empleados.add(e2);
		empleados.add(e3);
		
		Mockito.when(repo.findAll()).thenReturn(empleados);
		List<Employee> response = repo.findAll();
		
		assertEquals(empleados,response);
	}
	
	@Test
	public void save() {
		Employee employee = new Employee("1", 1000.00);
		
		Mockito.when(repo.save(Mockito.any())).thenReturn(employee);
		Employee response = repo.save(employee);
		
		assertEquals(employee,response);
	}

}
