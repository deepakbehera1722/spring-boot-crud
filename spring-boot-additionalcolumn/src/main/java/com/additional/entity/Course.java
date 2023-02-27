package com.additional.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Course {

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(int id, String courseName, Set<CourseRegistration> registration) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.registration = registration;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String courseName;
	@OneToMany(mappedBy = "course", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<CourseRegistration> registration;
	@CreationTimestamp
	private Date createdAt;
	@UpdateTimestamp
	private Date updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Set<CourseRegistration> getRegistration() {
		return registration;
	}

	public void setRegistration(Set<CourseRegistration> registration) {
		this.registration = registration;
	}

}
