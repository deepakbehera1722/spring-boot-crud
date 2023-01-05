package com.onetoone.repositorys;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onetoone.entity.Laptop;
import com.onetoone.entity.Student;

@Repository
public interface StudentsRepository extends JpaRepository<Student, Integer> {


}
