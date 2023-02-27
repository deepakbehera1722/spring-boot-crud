package com.additional.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class CourseRegistration {

	public CourseRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseRegistration(int id, Students student, Course course) {
		super();
		this.id = id;
		this.student = student;
		this.course = course;
	
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@ManyToOne
	@JoinColumn(name = "student_id")
	Students student;

	@ManyToOne
	@JoinColumn(name = "course_id")
	Course course;

	@CreationTimestamp
	private Date registeredAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Students getStudent() {
		return student;
	}

	public void setStudent(Students student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}



	
}
