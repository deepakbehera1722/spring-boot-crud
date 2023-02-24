package com.async.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.async.entity.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> {

}
