package com.example.demo;

public class Employee {
	
	private String name;
	private int id;
	private String address;
	private String email;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		this.email= name+id+"@example.com";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", address=" + address + ", email=" + email + "]";
	}
	public Employee(String name, int id, String address, String email) {
		super();
		this.name = name;
		this.id = id;
		this.address = address;
		this.email = email;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
