package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.User;
import com.example.services.UserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

	
	// CRUD operation
	@Autowired
	private UserService userservice;
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public void createUser(@RequestBody User user) {
		userservice.createUser(user);
	}
	
	@GetMapping("{userId}")
	public User getUserById(@PathVariable Long userId) {
		return userservice.findByUserId(userId);
	}
	@PutMapping("{userId}")
	public User updateUser(@PathVariable Long userId, @RequestBody User user) {
		return userservice.updateUser(userId, user);
	}
	
	@DeleteMapping("{userId}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable Long userId) {
		 userservice.deleteUser(userId);
	}
	
	/*
	 * @GetMapping
	 * public User findByusername(@RequestParam String username){
	 *     userservice.findByusername(username);
	 * 
	 * 
	 * */
	
}
