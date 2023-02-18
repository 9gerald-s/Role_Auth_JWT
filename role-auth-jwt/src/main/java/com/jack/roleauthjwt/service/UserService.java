package com.jack.roleauthjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jack.roleauthjwt.entity.User;
import com.jack.roleauthjwt.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public User createNewUser(User user) {
		User userdto = new User();
		userdto.setUserName(user.getUserName());
		userdto.setFirstName(user.getFirstName());
		userdto.setLastName(user.getLastName());
		userdto.setPassword(getEncodedPassword(user.getPassword()));
		return userRepo.save(userdto);
	}
	
	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}

}
