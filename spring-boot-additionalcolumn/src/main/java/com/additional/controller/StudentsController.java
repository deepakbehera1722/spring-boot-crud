package com.additional.controller;

import java.util.List;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.additional.entity.Students;
import com.additional.service.StudentsService;

@RestController
@RequestMapping("/students")
public class StudentsController {

	@Autowired
	private StudentsService studentsService;

	@GetMapping()
	public ResponseEntity<?> getAllStudents() {

		List<Students> students = studentsService.findAllStudents();
		if (students.isEmpty()) {
			return new ResponseEntity<>("Data Not Found", HttpStatus.NOT_FOUND);

		} else {

			return new ResponseEntity<>(students, HttpStatus.OK);
		}

	}

	@PostMapping()
	public ResponseEntity<?> addStudents(@RequestBody Students students) {

		studentsService.addStudents(students);
		return new ResponseEntity<>("Students Added Succesfully", HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable int id) throws Exception {

		try {
			Students student = studentsService.findStudentById(id);
			return new ResponseEntity<>(student, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateStudents(@PathVariable int id, @RequestBody Students student) throws Exception {
		try {
			studentsService.updateStudentById(id, student);
			return new ResponseEntity<>("Student Updated Sucessfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> DeleteStudet(@PathVariable int id) {
		studentsService.delete(id);
		return new ResponseEntity<>("Users Deleted Succesfully", HttpStatus.OK);
	}

}