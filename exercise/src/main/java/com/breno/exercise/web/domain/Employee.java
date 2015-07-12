package com.breno.exercise.web.domain;

/**
 * @author Breno
 *
 */
public class Employee {

	private String fname;
	private String lastname;
	private String deptId;

	public String getName() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getSurname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

}
