package com.huoji.useraccount.service;


import com.huoji.useraccount.dao.UserRepository;
import com.huoji.useraccount.model.SecurityUser;
import com.huoji.useraccount.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> userByEmail = userRepository.getUserByEmail(email);
		return userByEmail.map(SecurityUser::new)
				.orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));
	}
}
