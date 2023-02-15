package com.redis.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.redis.entity.Users;




@Repository
public class UserRepoServiceImpl implements UserRepoService{

	@Autowired
	private RedisTemplate redisTemplate;
	
	private static  final String KEY="Users";
	@Override
	public boolean saveUser(Users users) {
		// TODO Auto-generated method stub
		try
		{
			redisTemplate.opsForHash().put(users.getId().toString(),KEY,users);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	

	
	
}
