package com.additional.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.additional.entity.CourseRegistration;

public interface Registrantionrepo extends JpaRepository<CourseRegistration, Integer>{

}
