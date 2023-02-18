package com.jack.roleauthjwt.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jack.roleauthjwt.entity.User;
import com.jack.roleauthjwt.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostConstruct
	public void initRoleAndUser() {
		userService.initRoleAndUser();
	}

	@PostMapping("/createNewUser")
	public User createNewUser(@RequestBody User user) {
		return userService.createNewUser(user);
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('admin')")
	public String forAdmin() {
		return "admin got access";
	}

	@GetMapping("/user")
	@PreAuthorize("hasRole('user')")
	public String forUser() {
		return "user got access";
	}
}
