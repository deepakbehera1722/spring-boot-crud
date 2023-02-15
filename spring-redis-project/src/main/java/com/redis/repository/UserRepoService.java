package com.redis.repository;

import org.springframework.stereotype.Repository;

import com.redis.entity.Users;


public interface UserRepoService {

	boolean saveUser(Users users);



}
