package com.demo.kt.jpa.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.demo.kt.jpa.entity.Role;
import com.demo.kt.jpa.entity.User;
import com.demo.kt.jpa.repository.RoleRepository;
import com.demo.kt.jpa.repository.UserRepository;

import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;

@Service
public class RoleService {
	@Resource
	private RoleRepository roleRepository;
	@Resource
	private UserRepository userRepository;
	
	@Transactional
	public void addRoleToUser( Long uId, Long rId ) {
		User user =  userRepository.getReferenceById(uId);
		
		Role role = roleRepository.getReferenceById(rId);
		Set<Role> roles = user.getRoles();
		roles.add(role);
		
		user.setRoles(roles);
		
		userRepository.save(user);
	}
	
	
}
