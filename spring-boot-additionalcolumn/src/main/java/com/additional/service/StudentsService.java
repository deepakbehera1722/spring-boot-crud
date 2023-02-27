package com.additional.service;

import java.util.List;

import com.additional.entity.Students;

public interface StudentsService {

	public List<Students> findAllStudents();

	public Students addStudents(Students students);

	public Students findStudentById(int id) throws Exception;

	public Students updateStudentById(int id, Students students) throws Exception;

	void delete(int id);

}
