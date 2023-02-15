package com.redis.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redis.entity.Users;
import com.redis.repository.UserRepoService;
import com.redis.service.*;

@Service
public class UsersServiceImpl implements UserService {

	@Autowired
	private UserRepoService repoService;

	@Override
	public boolean saveUser(Users users) {
		// TODO Auto-generated method stub
		return repoService.saveUser(users);
	}
	
	

}
