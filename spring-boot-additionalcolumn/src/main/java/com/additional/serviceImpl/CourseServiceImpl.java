package com.additional.serviceImpl;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.additional.entity.Course;
import com.additional.entity.CourseRegistration;
import com.additional.repo.CourseRepo;
import com.additional.repo.Registrantionrepo;
import com.additional.service.CousreService;

@Service
public class CourseServiceImpl implements CousreService {
	@Autowired
	private CourseRepo courseRepo;
	@Autowired
	private Registrantionrepo registrantionrepo;

	@Override
	public List<Course> findAllCourse() {

		return courseRepo.findAll();
	}

	@Override
	public Course addCourse(Course course) {

		Course course1 = new Course();
		course1.setCourseName(course.getCourseName());
		course1.setRegistration(new HashSet<>(course.getRegistration()));
		return courseRepo.save(course1);
	}

	@Override
	public Course findCourseById(int id) throws Exception {

		return courseRepo.findById(id).orElseThrow(() -> new Exception("Course not Found"));
	}

	@Override
	public Course updateCourseById(int id, Course course) throws Exception {

		Course course1 = courseRepo.findById(id).orElseThrow(() -> new Exception("Course not Found"));
		course1.setCourseName(course.getCourseName());
		course1.setRegistration(new HashSet<>(course.getRegistration()));
		return courseRepo.save(course1);
	}

	@Override
	public void delete(int id) {

		courseRepo.deleteById(id);
	}

	public CourseRegistration AddedDetais(CourseRegistration courseRegistration)
	{
		return registrantionrepo.save(courseRegistration);
	}
	public List<CourseRegistration> getAllRegistration()
	{
		return registrantionrepo.findAll();
	}
}
