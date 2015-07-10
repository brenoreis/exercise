package com.breno.exercise;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MockService {
	
	private static int throttle;
	
	@Value("${max.requests.number}")
	private int max_requests_number; 
	
	
	public String save(Employee employee) {

		//check if max number reached
		if (throttle > max_requests_number) {
			return "Max request number reached - " + max_requests_number;
		} else {
			return "Employee entry #" + throttle++ + " saved";
		}
		
	}

}
