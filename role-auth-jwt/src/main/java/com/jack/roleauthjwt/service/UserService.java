package com.jack.roleauthjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jack.roleauthjwt.entity.User;
import com.jack.roleauthjwt.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;

	public User createNewUser(User user) {
		return userRepo.save(user);
	}

}
