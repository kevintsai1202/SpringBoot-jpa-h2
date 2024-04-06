package com.demo.kt.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.kt.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsername(String username);
	public List<User> findByUsernameLike(String username);
	public List<User> findByUsernameContaining(String username);
	public List<User> findByAgeBetween(int min, int max);
	
//	public List<User> findByUsernameOrEmailContaining(String username);
}
