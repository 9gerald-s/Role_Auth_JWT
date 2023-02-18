package com.jack.roleauthjwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jack.roleauthjwt.entity.Role;
import com.jack.roleauthjwt.service.RoleService;

@RestController
public class RoleController {
	
	@Autowired
	private RoleService roleService;

	@PostMapping({"/createNewRole"})
	public Role createNewRole(@RequestBody Role role) {
		return roleService.createNewRole(role);
	}
	@GetMapping("/roles")
	public List<Role> getAllRoles() {
		return roleService.getAllRoles();
	}
}
