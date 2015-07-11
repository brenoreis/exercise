package com.breno.exercise.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.breno.exercise.web.domain.Employee;
import com.breno.exercise.web.service.IMockService;

@RestController
public class MockController {

	@Autowired
	private IMockService service;
	
	@RequestMapping(value= "/post", method = RequestMethod.POST)
	public ResponseEntity<String> post(@RequestBody Employee employee) {

		System.out.println("controller");
		return new ResponseEntity<String>(service.save(employee), HttpStatus.OK);
		
		
	}

	//check if service is running
	@RequestMapping(value= "/check", method = RequestMethod.GET)
	public @ResponseBody String check() {

		return "OK";
		
	}
 
}