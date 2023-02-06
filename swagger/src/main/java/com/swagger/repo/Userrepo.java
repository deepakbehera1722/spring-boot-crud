package com.swagger.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swagger.entity.Users;

public interface Userrepo extends JpaRepository<Users, Long> {

}
