package com.crud.controller;

import java.util.List;

import javax.persistence.GeneratedValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Users;
import com.crud.serviceimpl.Crudserviceimpl;

@RestController
@RequestMapping("/users")
public class Controller {

	@Autowired
	private Crudserviceimpl crudserviceimpl;

	@GetMapping("/{pageNo}/{pageSize}")

	public List<Users> getAll(@PathVariable int pageNo, @PathVariable int pageSize) {
		
		return crudserviceimpl.getAll(pageNo,pageSize);
	}

	@PostMapping("")
	public String addData(@RequestBody Users user) {
		crudserviceimpl.addUser(user);
		return "Successfull Added User";
	}
	@GetMapping("/{id}")
	public Users getById(@PathVariable Long id) throws Exception
	{
		return crudserviceimpl.getById(id);
	}
	@PutMapping("/{id}")
	public String updateData(@RequestBody Users user, @PathVariable Long id) throws Exception
	{
		crudserviceimpl.updateUser(user, id);
		return " Successfully Updated User";
	}
	@DeleteMapping("/{id}")
	public String deleteData(@PathVariable Long id) 
	{
		crudserviceimpl.deleteUser(id);
		return " Deleted ";
	}
	
	
}