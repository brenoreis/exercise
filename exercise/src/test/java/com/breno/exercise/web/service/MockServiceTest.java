package com.breno.exercise.web.service;

import org.junit.Assert;
import org.junit.Test;

import com.breno.exercise.web.domain.Employee;

public class MockServiceTest {

	@Test
	public void SaveWithNullTest() {

		MockService service = new MockService();

		Employee employee = null;

		String result = service.save(employee);

		Assert.assertEquals("Employee is null.", result);

	}


}
