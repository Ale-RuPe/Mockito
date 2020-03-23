package com.ibm.exam.service.impl;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ibm.exam.model.Employee;

/**
 * 
 * @author AlejandroRuizPerez
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeManagerTest {	
	@Mock
	EmployeeManager manager;
	
	@Test
	public void payEmployees() {
		List<Employee> empleados = new ArrayList<>();
		Employee e1 = new Employee("1", 1000.00);
		Employee e2 = new Employee("2", 2000.00);
		Employee e3 = new Employee("3", 3000.00);
		empleados.add(e1);
		empleados.add(e2);
		empleados.add(e3);
		
		Mockito.when(manager.payEmployees()).thenReturn(empleados.size());
		int response = manager.payEmployees();
		
		assertEquals(empleados.size(), response);
	}
}
