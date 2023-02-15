package com.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redis.entity.Users;
import com.redis.service.UserService;

@RestController
public class UsersController {

	@Autowired
	private UserService  userService;
	
	@PostMapping("/users")
	public ResponseEntity<String> save(@RequestBody Users users)
	{
		boolean result= userService.saveUser(users);
		if(result)
		{
			return ResponseEntity.ok( "Users Created");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
}
