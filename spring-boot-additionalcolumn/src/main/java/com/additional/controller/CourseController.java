package com.additional.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.additional.entity.Course;
import com.additional.entity.CourseRegistration;
import com.additional.service.CousreService;
import com.additional.serviceImpl.CourseServiceImpl;

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private CousreService cousreService;
	@Autowired 
	private CourseServiceImpl courseServiceImpl;

	@GetMapping()
	public ResponseEntity<?> getAllCourse() {

		List<Course> course = cousreService.findAllCourse();
		if (course.isEmpty()) {
			return new ResponseEntity<>("Data Not Found", HttpStatus.NOT_FOUND);

		} else {

			return new ResponseEntity<>(course, HttpStatus.OK);
		}

	}

	@PostMapping()
	public ResponseEntity<?> addCourse(@RequestBody Course course) {

		cousreService.addCourse(course);
		return new ResponseEntity<>("Course Added Succesfully", HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCourseById(@PathVariable int id) throws Exception {

		try {
			Course course = cousreService.findCourseById(id);
			return new ResponseEntity<>(course, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateCourse(@PathVariable int id, @RequestBody Course course) throws Exception {
		try {
			cousreService.updateCourseById(id, course);
			return new ResponseEntity<>("Course Updated Sucessfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> DeleteCourse(@PathVariable int id) {
		cousreService.delete(id);
		return new ResponseEntity<>("Users Deleted Succesfully", HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public String Added (@RequestBody CourseRegistration courseRegistration)
	{
		courseServiceImpl.AddedDetais(courseRegistration);
		return "registran Succesefully";
	}
	@GetMapping("/getdetails")
	public List<CourseRegistration> findAll()
	{
		return courseServiceImpl.getAllRegistration();
		
	}

}
