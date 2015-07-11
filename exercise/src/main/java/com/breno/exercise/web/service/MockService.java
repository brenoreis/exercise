package com.breno.exercise.web.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.breno.exercise.web.domain.Employee;

@Service
public class MockService implements IMockService {

	private static int throttle;

	@Value("${max.requests.number}")
	private int max_requests_number;

	public String save(Employee employee) {

		String result = null;
		
		if (employee != null) {
			
			throttle++;
			
			// check if max number reached
			if (throttle > max_requests_number) {
				result = "Request #" + throttle
						+ " Maximum number of requests reached - "
						+ max_requests_number;
			} else {
				result =  "Request #" + throttle + " processed";
			}
		} else {
			result = "Employee is null.";
		}
		
		return result;
	}

}
