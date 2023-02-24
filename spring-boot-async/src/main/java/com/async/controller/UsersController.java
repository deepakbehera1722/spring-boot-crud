package com.async.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.async.entity.Users;
import com.async.service.UsersService;

@RestController
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@PostMapping("/sync")
	public void postData(@RequestBody Users users) {
		usersService.addUsers(users);
		usersService.getUser();
		
	}
	
	@GetMapping("/users")
	public List<Users> getAllData(){
		return usersService.findAllusers();
	}
}
