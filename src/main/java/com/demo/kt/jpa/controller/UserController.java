package com.demo.kt.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.kt.jpa.entity.User;
import com.demo.kt.jpa.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser(){
		return ResponseEntity.ok(userService.list());
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> addAllUser(@RequestBody User user){
		return ResponseEntity.ok(userService.createUser(user));
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity deleteUser(@PathVariable("id") Long id, @RequestParam("pagesize") int pagesize) {
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}
