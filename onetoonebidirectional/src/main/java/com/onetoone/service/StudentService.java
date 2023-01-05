package com.onetoone.service;

import java.util.List;


import com.onetoone.entity.Student;

public interface StudentService {

	public List<Student> findAll();

	public Student addStudent(Student student);

	public Student getById(int id) throws Exception;

	public Student updateStudent(Student student,int id) throws Exception;

	public void deleteStudent(int id);
	

}
