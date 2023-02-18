package com.jack.roleauthjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jack.roleauthjwt.entity.User;
import com.jack.roleauthjwt.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/createNewUser")
	public User createNewUser(@RequestBody User user) {
		return userService.createNewUser(user);
	}
}
