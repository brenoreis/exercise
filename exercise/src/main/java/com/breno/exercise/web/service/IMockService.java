package com.breno.exercise.web.service;

import com.breno.exercise.web.domain.Employee;

/**
 * @author Breno
 *
 */
public interface IMockService {

	/**
	 * @param employee
	 * @return {@link String}
	 * 
	 *         Method that saves an employee.
	 * 
	 */
	String save(Employee employee);

}
