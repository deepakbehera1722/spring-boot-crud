package com.example.redis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.redis.entities.Users;
import com.example.redis.repository.UserRepository;
import com.example.redis.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RedisTemplate redisTemplate;

	private static final String KEY = "USERS";

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<Users> getData() {

		List<Users> usersEntities;
		usersEntities = redisTemplate.opsForHash().values(KEY);
		return usersEntities;
	}

	@Override
	public Users postData(Users users) {
		redisTemplate.opsForHash().put(KEY, users.getId().toString(), users);

		return userRepository.save(users);
	}

	@Override
	public Users getDataById(Long id) {

	
		Users user = (Users) redisTemplate.opsForHash().get(KEY, id.toString());
		return user;
	}

//	@Override
//	public User getDataById(Long id) {
//		User user=userRepository.findById(id);
//		user= redisTemplate.opsForHash().values(KEY);
//		return (User) userRepository.findAll();
//	}

//	@Override
//	public List<Object> updateById(User user, Long id) {
//		// TODO Auto-generated method stub
//		List<Object> us = userRepository.findById(id);
//		return us;
//		
//	}

}
