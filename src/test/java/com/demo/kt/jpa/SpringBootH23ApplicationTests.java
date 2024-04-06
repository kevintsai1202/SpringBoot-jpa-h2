package com.demo.kt.jpa;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.demo.kt.jpa.entity.User;
import com.demo.kt.jpa.repository.UserRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
class SpringBootH23ApplicationTests {

	@Autowired
	UserRepository userRepository;
	
	@Test
	@Rollback(false)
	@Transactional
	void contextLoads() {
		
		User user1 = User.builder()
		.username("peter1")
		.email("kevin@gmail")
		.password("pwd")
		.build();
		
		User user2 = User.builder()
				.username("peter2")
				.email("kevin@gmail")
				.password("pwd")
				.build();
		User user3 = User.builder()
				.username("peter3")
				.email("kevin@gmail")
				.password("pwd")
				.build();
		User user4 = User.builder()
				.username("peter4")
				.email("kevin@gmail")
				.password("pwd")
				.build();
		
		List<User> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		userRepository.saveAll(users);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	void contextLoads1() {
		User user = userRepository.getReferenceById(1L);
		user.setAge(20);
		user = userRepository.save(user);
		System.out.println(user);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	void contextLoads3(){
		User user = userRepository.getReferenceById(2L);
		userRepository.delete(user);
	}
	
	@Test
	@Transactional
	void contextLoads2() {
		List<User> users = userRepository.findAll();
		System.out.println(users);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	void contextLoads4(){
		List<User> users = userRepository.findByAgeBetween(10, 30);
		System.out.println(users);
	}

}
