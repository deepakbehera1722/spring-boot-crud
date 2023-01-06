package com.onetoone.service;

import java.util.List;

import com.onetoone.entity.Laptop;

public interface LaptopService {
	public List<Laptop> getAllLaptop();

	public Laptop getByLaptopId(int id) throws Exception;
	
	public Laptop addLaptop(Laptop laptop);
	
	public Laptop  updateLaptop(Laptop laptop ,int id) throws Exception;
	
	public void deleteLaptop(int id);
	

}
