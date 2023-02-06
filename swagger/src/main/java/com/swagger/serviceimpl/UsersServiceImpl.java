package com.swagger.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swagger.entity.Users;
import com.swagger.service.UserService;
import com.swagger.repo.*;

@Service
public class UsersServiceImpl implements UserService {

	@Autowired
	private Userrepo repo;
	
	@Override
	public List<Users> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Users findById(long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow();
	}

	@Override
	public Users addData(Users user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}

	@Override
	public Users putData(long id, Users user) {
		// TODO Auto-generated 2method stub
		Users user2=repo.findById(id).orElseThrow(null);
		user2.setName(user.getName());
		user2.setEmail(user.getEmail());
		return repo.save(user2);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
