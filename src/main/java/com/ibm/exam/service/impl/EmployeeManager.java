package com.ibm.exam.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.exam.model.Employee;
import com.ibm.exam.repository.EmployeeRepository;
import com.ibm.exam.service.api.BankService;

/**
 * "Todo es divertido, con tal de que le suceda a otra persona"
 * 
 * @author JMA
 *
 */
@Service
public class EmployeeManager {

	private static final Logger LOGGER = LogManager.getLogger(EmployeeManager.class);

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	BankService bankService;

	public int payEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		int payments = 0;
		for (Employee employee : employees) {
			try {
				bankService.pay(employee.getId(), employee.getSalary());
				employee.setPaid(true);
				payments++;
			} catch (RuntimeException e) {
				LOGGER.error("Failed payment of " + employee, e);
				employee.setPaid(false);
			}
		}
		return payments;
	}

}
