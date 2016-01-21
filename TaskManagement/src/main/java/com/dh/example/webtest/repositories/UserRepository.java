package com.dh.example.webtest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dh.example.webtest.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserName(String userName);

	//User findByUserName(String uName);
	
}
