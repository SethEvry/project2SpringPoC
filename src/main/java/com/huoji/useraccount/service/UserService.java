package com.huoji.useraccount.service;

import com.huoji.useraccount.dao.UserRepository;
import com.huoji.useraccount.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;


	public List<User> getUsers() {
		return userRepository.findAll();
	}

}
