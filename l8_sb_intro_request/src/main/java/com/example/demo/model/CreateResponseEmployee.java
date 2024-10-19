package com.example.demo.model;

import com.example.demo.Employee;

public class CreateResponseEmployee {

	private int status;
	private String message;
	
	private Employee data;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Employee getData() {
		return data;
	}

	public void setData(Employee data) {
		this.data = data;
	}
	
}
