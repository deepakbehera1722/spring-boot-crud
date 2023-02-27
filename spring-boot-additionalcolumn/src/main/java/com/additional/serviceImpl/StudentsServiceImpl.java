package com.additional.serviceImpl;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.additional.entity.Students;
import com.additional.repo.StudentsRepo;
import com.additional.service.StudentsService;

@Service
public class StudentsServiceImpl implements StudentsService {
	@Autowired
	private StudentsRepo studentsRepo;

	@Override
	public List<Students> findAllStudents() {

		return studentsRepo.findAll();
	}

	@Override
	public Students addStudents(Students students) {
		Students students1 = new Students();
		students1.setStudentName(students.getStudentName());
		students1.setStudentEmail(students.getStudentEmail());
		students1.setRegistration(new HashSet<>(students.getRegistration()));
		return studentsRepo.save(students1);

	}

	@Override
	public Students findStudentById(int id) throws Exception {
		return studentsRepo.findById(id).orElseThrow(() -> new Exception("Users not found"));

	}

	@Override
	public Students updateStudentById(int id, Students students) throws Exception {
	Students student2=studentsRepo.findById(id).orElseThrow(() -> new Exception("Users not found"));
	student2.setStudentName(students.getStudentName());
	student2.setStudentEmail(students.getStudentEmail());
	student2.setRegistration(new HashSet<>(students.getRegistration()));
	return studentsRepo.save(student2);
	
	}

	@Override
	public void delete(int id) {
		
      studentsRepo.deleteById(id);
	}

}
