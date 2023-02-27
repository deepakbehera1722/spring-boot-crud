package com.additional.service;

import java.util.List;

import com.additional.entity.Course;

public interface CousreService {
	List<Course> findAllCourse();

	public Course addCourse(Course course);

	public Course findCourseById(int id) throws Exception;

	public Course updateCourseById(int id, Course course) throws Exception;

	void delete(int id);

}
