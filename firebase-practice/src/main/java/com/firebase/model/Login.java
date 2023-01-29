package com.firebase.model;

import java.util.HashMap;

public class Login {
	private String firstname;
	private String lastname;
	private Long salary;
	private Long result;
	private String methodStatus;
	
//	HashMap<String, Object> getResultValue(){
//		HashMap<String, Object> map = new HashMap<>();
//		map.put(Login.get)
//		return map;
//	}
	
	public String getMethodStatus() {
		return methodStatus;
	}
	public void setMethodStatus(String methodStatus) {
		this.methodStatus = methodStatus;
	}
	public Long getResult() {
		return result;
	}
	public void setResult(Long result) {
		this.result = result;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	
	
}
