package com.onetoone.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetoone.entity.Laptop;
import com.onetoone.repositorys.LaptopRepository;
import com.onetoone.service.LaptopService;


@Service
public class LaptopServiceImpl implements LaptopService{

	@Autowired
	private LaptopRepository laptopRepository;
	@Override
	public List<Laptop> getAllLaptop() {
		// TODO Auto-generated method stub
		return laptopRepository.findAll();
	}

	@Override
	public Laptop getByLaptopId(int id) throws Exception {
		// TODO Auto-generated method stub
		return laptopRepository.findById(id).orElseThrow(()->new Exception(" id dosen't exit"));
	}

	@Override
	public Laptop addLaptop(Laptop laptop) {
		// TODO Auto-generated method stub
		return laptopRepository.save(laptop);
	}

	@Override
	public Laptop updateLaptop(Laptop laptop, int id) throws Exception {
		// TODO Auto-generated method stub
		Laptop l=laptopRepository.findById(id).orElseThrow(()->new Exception(" id dosen't exit"));
		l.setLaptopName(laptop.getLaptopName());
		l.setModelNo(laptop.getModelNo());
		return laptopRepository.save(l);
	}

	@Override
	public void deleteLaptop(int id) {
		// TODO Auto-generated method stub
		 laptopRepository.deleteById(id);
		
	}

}
