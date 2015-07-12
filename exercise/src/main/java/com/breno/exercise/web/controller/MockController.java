package com.breno.exercise.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.breno.exercise.web.domain.Employee;
import com.breno.exercise.web.service.IMockService;

/**
 * @author Breno
 *
 *         REST Controller responsible to handle the calls from the clients.
 */
@RestController
public class MockController {

	@Autowired
	private IMockService service;

	/**
	 * @param employee
	 * @return {@link ResponseEntity<String>}
	 * 
	 *         Method responsible to handle the post requests.
	 * 
	 */
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public ResponseEntity<String> post(@RequestBody Employee employee) {

		System.out.println("controller");
		return new ResponseEntity<String>(service.save(employee), HttpStatus.OK);

	}

	/**
	 * @return {@link ResponseEntity<String>}
	 * 
	 *         Method used to check if the webservice is running.
	 * 
	 */
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public ResponseEntity<String> check() {

		return new ResponseEntity<String>("OK", HttpStatus.OK);

	}

}