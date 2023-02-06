package com.swagger.service;

import java.util.List;

import com.swagger.entity.Users;

public interface UserService {
	public List<Users> getAll();

	public Users findById(long id);

	public Users addData(Users user);

	public Users putData(long id, Users user);

	public void delete(long id);

}
