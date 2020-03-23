package com.ibm.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.exam.model.Employee;
import com.ibm.exam.repository.EmployeeRepository;
import com.ibm.exam.service.api.BankService;
import com.ibm.exam.service.api.TransactionManager;

/**
 * "Trabajar no es malo, lo malo es tener que trabajar"
 * 
 * @author JMA
 *
 */
@Service
public class TransactionalEmployeeManager {

	@Autowired
	TransactionManager transactionManager;

	@Autowired
	private BankService bankService;

	public void payEmployees() {
		List<Employee> employees = transactionManager.doInTransaction(EmployeeRepository::findAll);
		for (Employee employee : employees) {
			bankService.pay(employee.getId(), employee.getSalary());
			employee.setPaid(true);
			transactionManager.doInTransaction(employeeRepository -> employeeRepository.save(employee));
		}
	}

}
