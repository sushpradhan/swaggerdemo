package com.stackroute.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.demo.model.User;
import com.stackroute.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public boolean addUser(User user) {
		try {
			userRepository.save(user);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean validate(String username, String password) {
	
		if(userRepository.validate(username, password) != null ) {
			return true;
		}else {
			return false;
		}
	
	
	}

	
	
}
