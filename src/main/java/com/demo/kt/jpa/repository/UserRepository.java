package com.demo.kt.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.demo.kt.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsernameAndEmail(String username, String email);
	public List<User> findByUsernameLike(String username);
	public List<User> findByUsernameContaining(String username);
	public List<User> findByAgeBetween(int min, int max);
	
	
	@Modifying
	@Query(value="UPDATE T_USER SET email = ?1 WHERE id = ?2", nativeQuery = true)
	public void updateUser(String email, Long id);
//	public List<User> findByUsernameOrEmailContaining(String username);
}
