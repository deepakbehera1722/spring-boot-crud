package com.onetoone.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetoone.entity.Student;
import com.onetoone.repositorys.StudentsRepository;
import com.onetoone.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentsRepository studentsRepository;

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentsRepository.findAll();
	}

	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentsRepository.save(student);
	}

	@Override
	public Student getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return studentsRepository.findById(id).orElseThrow(() -> new Exception("id dosn't exit"));
	}

	@Override
	public Student updateStudent(Student student, int id) throws Exception {
		// TODO Auto-generated method stub
		Student s = studentsRepository.findById(id).orElseThrow(() -> new Exception("id dosn't exit"));
		s.setAge(student.getAge());
		s.setName(student.getName());
		return studentsRepository.save(s);

	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		studentsRepository.deleteById(id);

	}

}
