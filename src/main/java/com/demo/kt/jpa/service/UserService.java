package com.demo.kt.jpa.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.kt.jpa.entity.Profile;
import com.demo.kt.jpa.entity.User;
import com.demo.kt.jpa.repository.ProfileRepository;
import com.demo.kt.jpa.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProfileRepository profileRepository;
	
	@Transactional
	public User createUser(User user, Profile profile) {
		User savedUser = null;
		savedUser = userRepository.save(user);
		profile.setUser(savedUser);
		profileRepository.save(profile);
		return savedUser;
	}
	
}
