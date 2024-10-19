package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CreateRequestEmployeeModel;
import com.example.demo.model.CreateResponseEmployee;

@RequestMapping("/emp")
@RestController
public class EmployeeController {

	HashMap<Integer, Employee> hm=new HashMap<Integer, Employee>();
	
	@PostMapping("/create")
	public CreateResponseEmployee createEmployee(@RequestBody CreateRequestEmployeeModel emp) {
		CreateResponseEmployee empResponse = new CreateResponseEmployee();
		
		if(hm.containsKey(emp.getId())) {
			empResponse.setMessage("Employee Already Exists.");
			empResponse.setStatus(400);
		}else {
			Employee e = new Employee();
			e.setId(emp.getId());
			e.setAddress(emp.getAddress());
			e.setName(emp.getName());
			empResponse.setMessage("Success");
			empResponse.setStatus(200);
			hm.put(e.getId(), e);
			empResponse.setData(hm.get(e.getId()));
		}
		return empResponse;
	}
	
	@GetMapping("/get/{id}")
	public CreateResponseEmployee getEmployee(@PathVariable int id) {
		CreateResponseEmployee empResponse = new CreateResponseEmployee();
		
		if(hm.containsKey(id)) {
			empResponse.setData(hm.get(id));
			empResponse.setMessage("Success");
			empResponse.setStatus(200);
		}else {
			//empResponse.setData(hm.get(id));
			empResponse.setMessage("Employee doesnot exists");
			empResponse.setStatus(500);
		}
		
		
		return empResponse;
	}
	
	@GetMapping("/get/all")
	public List<Employee> getAllEmployees() {
		
		List<Employee> empList = new ArrayList<Employee>(hm.values());
		
				
		return empList;
	}
	
	@PostMapping("/update/{id}")
	public Employee updateemployee(@PathVariable int id ,@RequestParam String name,@RequestParam String email,@RequestParam String address) {
		Employee emp = hm.get(id);
		
		if(name.equals("")|| name == null) {
			
		}else {
			emp.setName(name);
		}
		if(email.equals("")|| email == null) {
			
		}else {
			emp.setName(email);
		}
		if(address.equals("")|| address == null) {
			
		}else {
			emp.setName(address);
		}
		System.out.println("Before:"+hm.get(id));
		System.out.println("After:"+emp);
		hm.put(emp.getId(), emp);
		return hm.get(id);
	}
	
	@DeleteMapping("/remove/{id}")
	public Employee deleteEmployee(@PathVariable int id) {
		Employee e = hm.remove(hm.remove(id));
		System.out.println("after Deletion :: "+hm);
		return e;
	}
	// Output:
	//after Deletion :: {1=Employee [name=Aditya, id=1, address=Delhi, email=aditya@aditya.com], 3=Employee [name=Aditya, id=3, address=Delhi, email=aditya@aditya.com]}

	
	
}
