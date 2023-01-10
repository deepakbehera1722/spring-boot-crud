package com.crud.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.entity.Users;

@org.springframework.stereotype.Repository
public interface Repositorys extends JpaRepository<Users, Long> {

}
