package com.additional.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.additional.entity.Students;

@Repository
public interface StudentsRepo extends JpaRepository<Students, Integer> {

}
