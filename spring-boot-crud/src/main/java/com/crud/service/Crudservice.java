package com.crud.service;

import java.util.List;

import com.crud.entity.Users;

public interface Crudservice {
	
	public List<Users> getAll(int pageNo,int pageSize);
	
	public Users getById(Long id) throws Exception;
	
	public String addUser(Users user);
	
	public String deleteUser(Long id);
	
	public String updateUser(Users user,Long id) throws Exception;

}
