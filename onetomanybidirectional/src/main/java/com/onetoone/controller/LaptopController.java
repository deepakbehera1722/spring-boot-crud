package com.onetoone.controller;

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

import com.onetoone.entity.Laptop;

import com.onetoone.serviceimpl.LaptopServiceImpl;


@RestController
@RequestMapping("/laptop")
public class LaptopController {

	@Autowired
	private LaptopServiceImpl laptopServiceImpl;

	@GetMapping()
	public List<Laptop> getAll() {

		return laptopServiceImpl.getAllLaptop();

	}
	@GetMapping("/{id}")
	public Laptop getByLaptopId(@PathVariable int id) throws Exception {
		return laptopServiceImpl.getByLaptopId(id);
	}

	@PostMapping()
	public String addLaptop(@RequestBody Laptop laptop) {
		laptopServiceImpl.addLaptop(laptop);
		return "laptop added";
	}
	@PutMapping("/{id}")
	public String updateLaptop(@RequestBody Laptop laptop,@PathVariable int id) throws Exception
	{
		laptopServiceImpl.updateLaptop(laptop,id);
		return "Update Succesfully";
	}
	@DeleteMapping("/{id}")
	public String deleteLaptop(@PathVariable int id)
	{
		laptopServiceImpl.deleteLaptop(id);
		return "Delete Succesfully";
	}
}
