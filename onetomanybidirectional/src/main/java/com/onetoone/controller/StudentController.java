package com.onetoone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.onetoone.entity.Student;
import com.onetoone.serviceimpl.StudentServiceImpl;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentServiceImpl studentServiceImpl;

	@GetMapping()
	public List<Student> getall() {

		return studentServiceImpl.findAll();

	}

	@GetMapping("/{id}")
	public Student getById(@PathVariable int id) throws Exception {
		return studentServiceImpl.getById(id);
	}

	@PostMapping()

	public String putData(@RequestBody Student student) {
		studentServiceImpl.addStudent(student);
		return "Student added Successfully";
	}

	@PutMapping("/{id}")

	public String updateData(@RequestBody Student student, @PathVariable int id) throws Exception {
		studentServiceImpl.updateStudent(student, id);
		return "update succesfully";
	}

	@DeleteMapping("/{id}")
	public String deleteData(@PathVariable int id) {
		studentServiceImpl.deleteStudent(id);
		return "Delete Succcesfully";
	}

	
}