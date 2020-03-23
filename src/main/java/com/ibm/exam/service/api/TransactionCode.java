package com.ibm.exam.service.api;

import java.util.function.Function;

import com.ibm.exam.repository.EmployeeRepository;

/**
 * "Al que madruga, nadie le hace el desayuno"
 * 
 * @author JMA
 *
 */
@FunctionalInterface
public interface TransactionCode<T> extends Function<EmployeeRepository, T> {

}
