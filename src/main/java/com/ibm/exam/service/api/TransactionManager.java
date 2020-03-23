package com.ibm.exam.service.api;

/**
 * "Me hago responsable de lo que digo, no de lo que entiendas"
 * 
 * @author JMA
 *
 */
public interface TransactionManager {

	<T> T doInTransaction(TransactionCode<T> code);

}
