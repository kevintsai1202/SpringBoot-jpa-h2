package com.demo.kt.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.demo.kt.jpa.entity.Profile;
import com.demo.kt.jpa.entity.Role;
import com.demo.kt.jpa.entity.User;
import com.demo.kt.jpa.repository.ProfileRepository;
import com.demo.kt.jpa.repository.RoleRepository;
import com.demo.kt.jpa.repository.UserRepository;
import com.demo.kt.service.RoleService;

import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;

@SpringBootTest
class SpringBootH23ApplicationTests {

	@Resource
	private UserRepository userRepository;
//	
//	@Resource
//	private ProfileRepository profileRepository;
//	
	@Resource
	private RoleRepository roleRepository;
	
//	@Autowired
//	private RoleService roleService;
	
//	@Test
//	@Rollback(false)
//	@Transactional
//	void contextLoads() {
//		
//		User user1 = User.builder()
//		.username("peter1")
//		.email("kevin@gmail")
//		.password("pwd")
//		.build();
//		
//		User user2 = User.builder()
//				.username("peter2")
//				.email("kevin@gmail")
//				.password("pwd")
//				.build();
//		User user3 = User.builder()
//				.username("peter3")
//				.email("kevin@gmail")
//				.password("pwd")
//				.build();
//		User user4 = User.builder()
//				.username("peter4")
//				.email("kevin@gmail")
//				.password("pwd")
//				.build();
//		
//		List<User> users = new ArrayList<>();
//		users.add(user1);
//		users.add(user2);
//		users.add(user3);
//		users.add(user4);
//		userRepository.saveAll(users);
//	}
//	
//	@Test
//	@Transactional
//	@Rollback(false)
//	void contextLoads1() {
//		User user = userRepository.getReferenceById(1L);
//		user.setAge(20);
//		user = userRepository.save(user);
//		System.out.println(user);
//	}
//	
//	@Test
//	@Transactional
//	@Rollback(false)
//	void contextLoads3(){
//		User user = userRepository.getReferenceById(2L);
//		userRepository.delete(user);
//	}
//	
//	@Test
//	@Transactional
//	void contextLoads2() {
//		List<User> users = userRepository.findAll();
//		System.out.println(users);
//	}
//	
//	@Test
//	@Transactional
//	@Rollback(false)
//	void contextLoads4(){
//		List<User> users = userRepository.findByAgeBetween(10, 30);
//		System.out.println(users);
//	}
//
//	@Test
//	@Transactional
//	@Rollback(false)
//	void contextLoads5(){
//		
//		
//		User user = userRepository.getReferenceById(155L);
//		user.setEmail("TEST@GMAIL");
//		user = userRepository.save(user);
//		System.out.println(user);
//	}
//	
//	@Test
//	@Transactional
//	@Rollback(false)
//	void contextLoads6(){
//		User user = userRepository.getReferenceById(152L);
//		Profile profile = Profile.builder()
//			.address("ABCDEFG")
//			.user(user)
//		.build();
//		
//		profileRepository.save(profile);
//	}
//	
//	@Test
//	@Transactional
//	void contextLoads7(){
//		User user = userRepository.getReferenceById(152L);		
//		System.out.println(user);
//	}
//	
//	@Test
//	@Transactional
//	@Rollback(false)
//	void contextLoads8(){
//		User user = userRepository.getReferenceById(152L);		
//		userRepository.delete(user);
//	}
//	
//	@Test
//	@Transactional
//	@Rollback(false)
//	void contextLoads9(){
//		Profile profile = profileRepository.getReferenceById(1L);		
//		profileRepository.delete(profile);
//	}
//	
//	
//	@Test
//	@Transactional
//	@Rollback(false)
//	void contextLoads10() {
//		Role role1 = Role.builder()
//				.roleName("USER")
//				.build();
//		Role role2 = Role.builder()
//				.roleName("ADMIN")
//				.build();
//		
//		roleRepository.save(role1);
//		roleRepository.save(role2);
//	}
	
	public void addRoleToUser( Long uId, Long rId ) {
		User user =  userRepository.getReferenceById(uId);
		
		Role role = roleRepository.getReferenceById(rId);
		Set<Role> roles = user.getRoles();
		roles.add(role);
		
		user.setRoles(roles);
		
		userRepository.save(user);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	void contextLoads11() {

		addRoleToUser(3L, 1L);
		addRoleToUser(3L, 2L);
		addRoleToUser(4L, 1L);
		addRoleToUser(5L, 2L);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	void contextLoads12() {
		User user = userRepository.getReferenceById(5L);
		System.out.println(user);
	}
}
