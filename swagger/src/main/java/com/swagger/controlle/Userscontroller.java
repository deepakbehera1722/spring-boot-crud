package com.swagger.controlle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.entity.Users;
import com.swagger.serviceimpl.UsersServiceImpl;

@RestController
@RequestMapping("/users")
public class Userscontroller {
	@Autowired
	private UsersServiceImpl impl;
	@GetMapping()
	public List<Users> getAllUsers()
	{
		return impl.getAll();
	}
	@GetMapping("/{id}")
	
		public Users  getUsersById(@PathVariable long id)
		{
		return impl.findById(id);
	}
	@PostMapping()
	public String addUsers(@RequestBody Users users)
	{
		impl.addData(users);
		return "Users Added";
	}
	@PutMapping("/{id}")
	public String updateUsers(@PathVariable long id,@RequestBody Users user)
	{
		impl.putData(id, user);
		return "Update Users";
	}
	@DeleteMapping("{id}")
	public String deleteUsers(@PathVariable long id)
	{
	impl.delete(id);	
	return "deleted Users";
	}
}
