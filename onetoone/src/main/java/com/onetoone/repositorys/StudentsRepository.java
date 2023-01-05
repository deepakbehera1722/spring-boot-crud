package com.onetoone.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onetoone.entity.Student;

@Repository
public interface StudentsRepository extends JpaRepository<Student, Integer> {

}
