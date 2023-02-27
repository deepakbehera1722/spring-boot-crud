package com.additional.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.additional.entity.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {

}
