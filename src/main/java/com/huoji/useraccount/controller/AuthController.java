package com.huoji.useraccount.controller;

import com.huoji.useraccount.dto.LoginTemplate;
import com.huoji.useraccount.dto.Token;
import com.huoji.useraccount.service.TokenService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class AuthController {

	private final TokenService tokenService;
	private final AuthenticationManager authManager;

	public AuthController(TokenService tokenService, AuthenticationManager authManager) {
		this.tokenService = tokenService;
		this.authManager = authManager;
	}
	
	@PostMapping
	public Token token(@RequestBody LoginTemplate login, HttpServletResponse res) {
		Authentication authentication = authManager.authenticate(
				new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
		String token = tokenService.generateToken(authentication);
		Cookie cookie = new Cookie("auth.access_token", token);
		cookie.setSecure(true);
		cookie.setHttpOnly(true);
		cookie.setPath("/");
		res.addCookie(cookie);
		return new Token(token);
	}
}
