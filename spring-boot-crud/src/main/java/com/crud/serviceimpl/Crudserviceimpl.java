package com.crud.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.crud.entity.Users;
import com.crud.repository.Repositorys;
import com.crud.service.Crudservice;

@Service
public class Crudserviceimpl implements Crudservice {

	@Autowired
	private Repositorys repository;
	@Override
	public List<Users> getAll(int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		org.springframework.data.domain.Pageable p = PageRequest.of(pageNo - 1, pageSize);
		Page<Users> s = repository.findAll(p);

		List<Users> page = s.getContent();
		return page;
	}

	@Override
	public Users getById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return repository.findById(id).orElseThrow(()->new Exception("id dosn't exit"));
				}

	@Override
	public String addUser(Users user) {
		// TODO Auto-generated method stub
		repository.save(user);
		return null;
	}

	@Override
	public String deleteUser(Long id)  {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		return null;
	}

	@Override
	public String updateUser(Users user, Long id) throws Exception {
		// TODO Auto-generated method stub
		Users user1=repository.findById(id).orElseThrow(()->new Exception("id dosn't exit"));
		 //user1.setId(user.getId());
		user1.setName(user.getName());
		 user1.setEmail(user.getEmail());
		 repository.save(user1);
		return null;
	}

}
