package com.jack.roleauthjwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jack.roleauthjwt.entity.Role;
import com.jack.roleauthjwt.repository.RoleRepo;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepo roleRepo;

	public Role createNewRole(Role role) {
		return roleRepo.save(role);
	}

	public List<Role> getAllRoles() {
		return roleRepo.findAll();
	}

}
