package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.User;
import com.example.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;




@Service
@Slf4j
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	public void createUser(User user) {
		
		log.info("UserService :: createrUser {}",  user.getUsername());
		userRepository.save(user);
		log.info("User saved successfully in DB");
		
	}
	public List<User> fetchAllUser(){
		log.info("UserService :: fetchAllUser");
		return userRepository.findAll();
		}
	
	public User findByUserId(Long userId) {
	 log.info("UserService :: findByUserId {} ",userId);
		return userRepository.findById(userId).orElseThrow(()->new EntityNotFoundException("user not found"));
	}
	
	public User updateUser(Long userId,User inputUser) {
		return userRepository.findById(userId).map(obj->{
		obj.setEmail(inputUser.getEmail());
			obj.setUsername(inputUser.getUsername());
			obj.setPassword(inputUser.getPassword());
			
			return userRepository.save(obj);
		}).orElseThrow(()->new EntityNotFoundException("user not found"));
	}
	public void deleteUser(long userId) {
		if(userRepository.existsById(userId)) {
			userRepository.deleteById(userId);
		}else {
	throw new EntityNotFoundException("UserId not found");
	}
	

}
}
