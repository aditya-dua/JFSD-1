package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	@GetMapping
	public String test() {
		return "Test API works!!";
	}
	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	@GetMapping("/get/{id}")
	public Optional<Student> getStudent(@PathVariable int id) {
		return studentService.getStudent(id);
	}
	@GetMapping("/count")
	public long getCount() {
		return studentService.getTotalCount();
	}
	@GetMapping("/get/")
	public List<Student> getAll() {
		return studentService.getAll();
	}
	@GetMapping("/get/name/{name}")
	public Student getStudentByName(@PathVariable String name) {
		return studentService.getStudentByName(name);
	}
	
	@DeleteMapping("/delete/name/{name}")
	public String deleteStudentByName(@PathVariable String name) {
		return studentService.deleteStudent(name);
	}
}
