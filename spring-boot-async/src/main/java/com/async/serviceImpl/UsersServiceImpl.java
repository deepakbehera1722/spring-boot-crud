package com.async.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.async.entity.Users;
import com.async.repo.UsersRepo;
import com.async.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersRepo usersRepo;

	@Override
	public List<Users> findAllusers() {
		// TODO Auto-generated method stub
		return usersRepo.findAll();
	}

	@Override
	public Users addUsers(Users users) {
		// TODO Auto-generated method stub
		return usersRepo.save(users);
	}

	@Override
	public void getUser() {
		// TODO Auto-generated method stub
		try {
			System.out.println("sleep method started");
			Thread.sleep(10000);
			System.out.println("sleep method ended");
			List<Users> response = usersRepo.findAll();
			response.forEach(user -> {
				System.out.println("response data" + user.toString());
			});
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();// TODO Auto-generated method stub

		}
	}

}
