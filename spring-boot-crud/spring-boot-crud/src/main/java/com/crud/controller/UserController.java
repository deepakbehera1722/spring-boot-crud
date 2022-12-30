package com.crud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.crud.dto.*;
import com.crud.entity.Users;

import com.crud.serviceimpl.CrudServiceImpl;

@RestController
@RequestMapping("/users")
// Use ProperName 
public class UserController {

	@Autowired
	private CrudServiceImpl crudServiceImpl; // naming convention
//get by all and pagination  with Dto and response entity

	@GetMapping()

	public ResponseEntity<?> getAllInfoCv(@RequestParam(value = "search") String search,
			@RequestParam(value = "pageNo") String pageNo, @RequestParam(value = "pageSize") String pageSize) {
		Page<IUsersDto> cvs = crudServiceImpl.findAllwithPage(search, pageNo, pageSize);
		if (cvs.getTotalElements() != 0) {
			return new ResponseEntity<>((cvs.getContent()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getbyId(@PathVariable long id) throws Exception {
		UsersDto usres = crudServiceImpl.getByIdfromDto(id);
		return new ResponseEntity<>(new Sucessdto("Sucesss", "sucess", usres), HttpStatus.OK);

	}

	// Add data
	@PostMapping() // avoid that type
	public ResponseEntity<?> addData(@Valid @RequestBody Users user) {
		crudServiceImpl.addUser(user);
		return new ResponseEntity<>(new ErrorDto(" Succesfully", "Added Users"), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateData(@Valid @RequestBody Users user, @PathVariable long id) throws Exception {

		crudServiceImpl.updateUser(user, id);

		return new ResponseEntity<>(new ErrorDto(" Successfully", "Updated User"), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteData(@PathVariable long id) {
		crudServiceImpl.deleteUser(id);
		return new ResponseEntity<>(new ErrorDto("Successfully", "Deleted User"), HttpStatus.OK);

	}

}