package com.jack.roleauthjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jack.roleauthjwt.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

}
