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
import com.ibm.exam.repository.EmployeeRepository;
import com.ibm.exam.service.api.BankService;
import com.ibm.exam.service.api.TransactionManager;

/**
 * 
 * @author AlejandroRuizPerez
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TransactionalEmployeeManagerTest {	
	@Mock
	TransactionManager transactionManager;
	
	@Mock
	BankService bankService;
	
	@Test
	public void payEmployees() {
		List<Employee> empleados = new ArrayList<>();
		Employee e1 = new Employee("1", 1000.00);
		empleados.add(e1);
		
		Mockito.when(
				transactionManager.doInTransaction(Mockito.any()) 
				).thenReturn(empleados);
		List<Employee> response = transactionManager.doInTransaction(EmployeeRepository::findAll);
		for(Employee empl : response) {
			bankService = (id, amount ) -> empl.setSalary(empl.getSalary()+100.00);
			bankService.pay(empl.getId(), empl.getSalary());
			empl.setPaid(true);
			transactionManager.doInTransaction(repo -> repo.save(empl) );
		}
		
		assertEquals(empleados, response);
	}
}
