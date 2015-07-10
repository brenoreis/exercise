package com.breno.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockController {

	@Autowired
	private MockService service;
	
	@RequestMapping(value= "/employee/create", method = RequestMethod.POST)
	public @ResponseBody String createEmployee(@RequestBody Employee employee) {

		return service.save(employee);
		
	}

	//check if service is running
	@RequestMapping(value= "/employee/check", method = RequestMethod.GET)
	public @ResponseBody String checkEmployee() {

		return "OK";
		
	}
 
}