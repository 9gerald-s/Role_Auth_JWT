package com.jack.roleauthjwt.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jack.roleauthjwt.entity.Role;
import com.jack.roleauthjwt.entity.User;
import com.jack.roleauthjwt.repository.RoleRepo;
import com.jack.roleauthjwt.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public void initRoleAndUser() {

		Role adminRole = new Role();
		adminRole.setRoleName("admin");
		adminRole.setRoleDescription("Admin role");
		roleRepo.save(adminRole);

		Role userRole = new Role();
		userRole.setRoleName("user");
		userRole.setRoleDescription("Default role for newly created record");
		roleRepo.save(userRole);

		User adminUser = new User();
		adminUser.setUserName("admin123");
		adminUser.setPassword(getEncodedPassword("admin@pass"));
		adminUser.setFirstName("admin");
		adminUser.setLastName("admin");
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRoles(adminRoles);
		userRepo.save(adminUser);

	}

	public User createNewUser(User user) {

		Role role = roleRepo.findById("user").get();
		Set<Role> roles = new HashSet<>();

		roles.add(role);
		user.setRoles(roles);
		user.setPassword(getEncodedPassword(user.getPassword()));

		return userRepo.save(user);
	}

	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}

}
