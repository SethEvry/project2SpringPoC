package com.huoji.useraccount.controller;

import com.huoji.useraccount.model.User;
import com.huoji.useraccount.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@GetMapping("/{email}")
	public User getUserByEmail(@PathParam(value = "email") String email) {
		try {
			return userService.getUserByEmail(email);
		} catch(NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}


}
