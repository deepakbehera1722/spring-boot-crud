package com.async.service;

import java.util.List;

import com.async.entity.Users;

public interface UsersService {
	public List<Users> findAllusers();

	public Users addUsers(Users users);
	
	public void getUser();

}
