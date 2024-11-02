package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	public Student createStudent(Student student) {
		return studentRepo.save(student);
	}
	
	
	public Optional<Student> getStudent(int id) {

		
		return studentRepo.findById(id);
	}
	
	public Student getStudentByName(String name) {
		return studentRepo.findByName(name);
	}
	
	public long getTotalCount() {
		return studentRepo.count();
	}
	
	public List<Student> getAll() {
		return studentRepo.findAll();
	}
	
	public String deleteStudent(String name) {
		Student stu = studentRepo.findByName(name);
		
		if(stu!=null) {
			studentRepo.delete(stu);
			return "Success";
		}else {
			return "Student Doesnot Exists";
		}
		
		
		
	}
	
}
